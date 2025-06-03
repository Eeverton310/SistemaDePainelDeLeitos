package com.HospitalDecos.SistemaDePainelDeLeitos.service;

import com.HospitalDecos.SistemaDePainelDeLeitos.dto.CirurgiaStatusDTO;
import com.HospitalDecos.SistemaDePainelDeLeitos.repository.HistoricoOcupacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CirurgiaStatusService {

    private final HistoricoOcupacaoRepository historicoOcupacaoRepository;

    public List<CirurgiaStatusDTO> listarStatusCirurgias() {
        List<CirurgiaStatusDTO> lista = historicoOcupacaoRepository.buscarStatusCirurgias();

        return lista.stream()
                .map(dto -> {
                    String nomeAbrev = CirurgiaStatusDTO.abreviarNome(dto.getNomeAbreviado());
                    dto.setNomeAbreviado(nomeAbrev);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}

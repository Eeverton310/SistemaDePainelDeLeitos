package com.HospitalDecos.SistemaDePainelDeLeitos.service;

import com.HospitalDecos.SistemaDePainelDeLeitos.dto.HistoricoCompletoDTO;
import com.HospitalDecos.SistemaDePainelDeLeitos.repository.HistoricoOcupacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CirurgiaStatusService {

    private final HistoricoOcupacaoRepository historicoOcupacaoRepository;

    // Remover o uso de CirurgiaStatusDTO e substituir por HistoricoCompletoDTO
    public List<HistoricoCompletoDTO> listarStatusCirurgias() {
        // Chama a consulta que agora existe, que é 'buscarHistoricoCompleto'
        List<HistoricoCompletoDTO> lista = historicoOcupacaoRepository.buscarHistoricoCompleto();

        return lista.stream()
                .map(dto -> {
                    // Lógica de abreviar nome ou outras transformações necessárias
                    dto.setNomeAbreviado(dto.getNome());  // Agora usando HistoricoCompletoDTO
                    return dto;
                })
                .collect(Collectors.toList());
    }
}

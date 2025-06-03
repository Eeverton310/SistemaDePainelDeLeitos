package com.HospitalDecos.SistemaDePainelDeLeitos.service;

import com.HospitalDecos.SistemaDePainelDeLeitos.dto.HistoricoCompletoDTO;
import com.HospitalDecos.SistemaDePainelDeLeitos.dto.CirurgiaStatusDTO;  // Importa para usar método de abreviação
import com.HospitalDecos.SistemaDePainelDeLeitos.repository.HistoricoOcupacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoricoOcupacaoService {
    private final HistoricoOcupacaoRepository historicoOcupacaoRepository;

    public List<HistoricoCompletoDTO> listarHistoricoCompleto() {
        List<HistoricoCompletoDTO> lista = historicoOcupacaoRepository.buscarHistoricoCompleto();

        return lista.stream().map(dto -> {
            // Abrevia o nome para iniciais
            dto.setNome(CirurgiaStatusDTO.abreviarNome(dto.getNome()));

            // Calcula idade baseado na dataNascimento
            if (dto.getDataNascimento() != null) {
                LocalDate dataNascimentoLocalDate = dto.getDataNascimento();
                int idade = Period.between(dataNascimentoLocalDate, LocalDate.now()).getYears();
                dto.setIdade(idade);
            } else {
                dto.setIdade(0);
            }

            return dto;
        }).collect(Collectors.toList());
    }
}

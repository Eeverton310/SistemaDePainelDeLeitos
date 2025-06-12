package com.HospitalDecos.SistemaDePainelDeLeitos.service;

import com.HospitalDecos.SistemaDePainelDeLeitos.dto.HistoricoCompletoDTO;
import com.HospitalDecos.SistemaDePainelDeLeitos.repository.HistoricoOcupacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
            // Remover a referência a CirurgiaStatusDTO
            dto.setNomeAbreviado(dto.getNome());  // Agora usando HistoricoCompletoDTO

            // Calcular idade
            if (dto.getDataNascimento() != null) {
                int idade = Period.between(dto.getDataNascimento(), LocalDate.now()).getYears();
                dto.setIdade(idade);
            } else {
                dto.setIdade(0);
            }

            // Calcular previsão de alta (1 hora após a entrada)
            if (dto.getDataEntrada() != null) {
                LocalDateTime previsaoAlta = dto.getDataEntrada().plusHours(1);
                dto.setPrevisaoAlta(previsaoAlta); // Define a previsão de alta
            }

            return dto;
        }).collect(Collectors.toList());
    }
}

package com.HospitalDecos.SistemaDePainelDeLeitos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoCompletoDTO {

    private String numero;
    private String nome;
    private char sexo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String nomeProcedimento;
    private String nomeCirurgiao;
    private LocalDateTime dataEntrada;

    private int idade;
    private String nomeAbreviado;

    // Novo campo para previsão de alta
    private LocalDateTime previsaoAlta;

    public HistoricoCompletoDTO(String numero, String nome, char sexo, LocalDate dataNascimento,
                                String nomeProcedimento, String nomeCirurgiao,
                                LocalDateTime dataEntrada) {  // Removido 'statusCirurgia'
        this.numero = numero;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.nomeProcedimento = nomeProcedimento;
        this.nomeCirurgiao = nomeCirurgiao;
        this.dataEntrada = dataEntrada;
    }
}

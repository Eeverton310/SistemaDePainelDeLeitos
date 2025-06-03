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

    private String numero;           // número do leito
    private String nome;             // nome do paciente
    private char sexo;               // sexo do paciente

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;  // data de nascimento do paciente

    private String nomeProcedimento;    // nome do procedimento
    private String nomeCirurgiao;       // nome do cirurgião
    private LocalDateTime dataEntrada;  // data de entrada
    private String statusCirurgia;      // status da cirurgia

    private int idade;                  // idade calculada no serviço

    // Construtor usado na query JPA (sem o campo idade)
    public HistoricoCompletoDTO(String numero, String nome, char sexo, LocalDate dataNascimento,
                                String nomeProcedimento, String nomeCirurgiao,
                                LocalDateTime dataEntrada, String statusCirurgia) {
        this.numero = numero;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.nomeProcedimento = nomeProcedimento;
        this.nomeCirurgiao = nomeCirurgiao;
        this.dataEntrada = dataEntrada;
        this.statusCirurgia = statusCirurgia;
    }
}

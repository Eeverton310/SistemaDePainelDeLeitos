package com.HospitalDecos.SistemaDePainelDeLeitos.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CirurgiaStatusDTO {
    private String pacienteAbreviado;
    private LocalDate dataNascimento;
    private String nomeCirurgiao;
    private String status;
}

package com.HospitalDecos.SistemaDePainelDeLeitos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CirurgiaStatusDTO {

    private String nomeAbreviado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    private String nomeCirurgiao;
    private String statusCirurgia;

    public static String abreviarNome(String nomeCompleto) {
        if (nomeCompleto == null || nomeCompleto.isBlank()) return "";

        String[] partes = nomeCompleto.trim().split("\\s+");
        if (partes.length == 1) {
            return partes[0].substring(0, 1).toUpperCase();
        }

        String primeiraLetra = partes[0].substring(0, 1).toUpperCase();
        String ultimaLetra = partes[partes.length - 1].substring(0, 1).toUpperCase();

        return primeiraLetra + "." + ultimaLetra;
    }
}

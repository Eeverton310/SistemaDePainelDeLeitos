package com.HospitalDecos.SistemaDePainelDeLeitos.dto;

import java.time.LocalDate;

public class CirurgiaStatusDTO {
    private String pacienteAbreviado;
    private LocalDate dataNascimento;
    private String nomeCirurgiao;
    private String status;

    public CirurgiaStatusDTO(String pacienteAbreviado, LocalDate dataNascimento, String nomeCirurgiao, String status) {
        this.pacienteAbreviado = pacienteAbreviado;
        this.dataNascimento = dataNascimento;
        this.nomeCirurgiao = nomeCirurgiao;
        this.status = status;
    }

    // Getters e setters
    public String getPacienteAbreviado() { return pacienteAbreviado; }
    public void setPacienteAbreviado(String pacienteAbreviado) { this.pacienteAbreviado = pacienteAbreviado; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getNomeCirurgiao() { return nomeCirurgiao; }
    public void setNomeCirurgiao(String nomeCirurgiao) { this.nomeCirurgiao = nomeCirurgiao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

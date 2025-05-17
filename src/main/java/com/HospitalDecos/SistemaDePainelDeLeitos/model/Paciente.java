package com.HospitalDecos.SistemaDePainelDeLeitos.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pacienteId;

    private String nome;
    private LocalDate dataNascimento;
    private char sexo;
    private LocalDate dataAdmissao;
    private Integer tempoInternacao;
    private Integer tempoPermanencia;
    private String previsaoAlta;

    @ManyToOne
    @JoinColumn(name = "leito_id")
    private Leito leito;


}

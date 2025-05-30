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
    private Long id;

    private String nome;
    private LocalDate dataNascimento;
    private char sexo;

    @ManyToOne
    @JoinColumn(name = "leito_id")
    private Leito leito;


}

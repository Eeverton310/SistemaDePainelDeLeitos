package com.HospitalDecos.SistemaDePainelDeLeitos.repository;

import com.HospitalDecos.SistemaDePainelDeLeitos.dto.HistoricoCompletoDTO;
import com.HospitalDecos.SistemaDePainelDeLeitos.model.HistoricoOcupacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoOcupacaoRepository extends JpaRepository<HistoricoOcupacao, Long> {

    @Query("SELECT new com.HospitalDecos.SistemaDePainelDeLeitos.dto.HistoricoCompletoDTO(" +
            "l.numero, p.nome, p.sexo, p.dataNascimento, proc.nome, c.nome, h.dataEntrada) " +  // Removido status
            "FROM HistoricoOcupacao h " +
            "JOIN h.leito l " +
            "JOIN h.paciente p " +
            "JOIN h.procedimento proc " +
            "JOIN h.cirurgiao c")
    List<HistoricoCompletoDTO> buscarHistoricoCompleto();
}

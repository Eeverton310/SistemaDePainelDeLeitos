package com.HospitalDecos.SistemaDePainelDeLeitos.repository;

import com.HospitalDecos.SistemaDePainelDeLeitos.dto.CirurgiaStatusDTO;
import com.HospitalDecos.SistemaDePainelDeLeitos.model.HistoricoOcupacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoOcupacaoRepository extends JpaRepository<HistoricoOcupacao, Long> {

    @Query("SELECT new com.HospitalDecos.SistemaDePainelDeLeitos.dto.CirurgiaStatusDTO(" +
            " p.nome, p.dataNascimento, c.nome, " +
            " CASE " +
            "   WHEN h.dataSaida IS NULL AND h.procedimento IS NOT NULL THEN 'Em Cirurgia' " +
            "   WHEN h.dataSaida IS NOT NULL THEN 'Alta para Internamento' " +
            "   ELSE 'Entrada SRPA' " +
            " END) " +
            "FROM HistoricoOcupacao h " +
            "JOIN h.paciente p " +
            "JOIN h.cirurgiao c")
    List<CirurgiaStatusDTO> buscarStatusCirurgias();
}

package com.HospitalDecos.SistemaDePainelDeLeitos.repository;

import com.HospitalDecos.SistemaDePainelDeLeitos.dto.CirurgiaStatusDTO;
import com.HospitalDecos.SistemaDePainelDeLeitos.dto.HistoricoCompletoDTO;
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

    @Query("SELECT new com.HospitalDecos.SistemaDePainelDeLeitos.dto.HistoricoCompletoDTO(" +
            "l.numero, p.nome, p.sexo, p.dataNascimento, proc.nome, c.nome, h.dataEntrada, " +
            "CASE " +
            " WHEN h.dataSaida IS NULL AND h.procedimento IS NOT NULL THEN 'Em Cirurgia' " +
            " WHEN h.dataSaida IS NOT NULL THEN 'Alta para Internamento' " +
            " ELSE 'Entrada SRPA' END) " +
            "FROM HistoricoOcupacao h " +
            "JOIN h.leito l " +
            "JOIN h.paciente p " +
            "JOIN h.procedimento proc " +
            "JOIN h.cirurgiao c")
    List<HistoricoCompletoDTO> buscarHistoricoCompleto();

}

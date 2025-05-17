package com.HospitalDecos.SistemaDePainelDeLeitos.repository;

import com.HospitalDecos.SistemaDePainelDeLeitos.model.HistoricoOcupacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoOcupacaoRepository extends JpaRepository<HistoricoOcupacao, Long> {
}

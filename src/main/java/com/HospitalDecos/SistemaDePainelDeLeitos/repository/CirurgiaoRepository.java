package com.HospitalDecos.SistemaDePainelDeLeitos.repository;

import com.HospitalDecos.SistemaDePainelDeLeitos.model.Cirurgiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CirurgiaoRepository extends JpaRepository<Cirurgiao, Long> {
}

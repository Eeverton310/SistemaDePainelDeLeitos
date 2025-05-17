package com.HospitalDecos.SistemaDePainelDeLeitos.repository;

import com.HospitalDecos.SistemaDePainelDeLeitos.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}

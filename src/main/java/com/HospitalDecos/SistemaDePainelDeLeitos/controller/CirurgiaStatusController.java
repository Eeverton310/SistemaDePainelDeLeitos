package com.HospitalDecos.SistemaDePainelDeLeitos.controller;

import com.HospitalDecos.SistemaDePainelDeLeitos.dto.CirurgiaStatusDTO;
import com.HospitalDecos.SistemaDePainelDeLeitos.repository.HistoricoOcupacaoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class CirurgiaStatusController {

    @Autowired
    private HistoricoOcupacaoRepository historicoOcupacaoRepository;

    @GetMapping("/api/cirurgias/status")
    public List<CirurgiaStatusDTO> listarStatusCirurgias() {
        return historicoOcupacaoRepository.buscarStatusCirurgias();
    }
}

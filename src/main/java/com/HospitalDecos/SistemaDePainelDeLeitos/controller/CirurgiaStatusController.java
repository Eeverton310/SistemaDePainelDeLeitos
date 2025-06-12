package com.HospitalDecos.SistemaDePainelDeLeitos.controller;

import com.HospitalDecos.SistemaDePainelDeLeitos.dto.HistoricoCompletoDTO;
import com.HospitalDecos.SistemaDePainelDeLeitos.service.HistoricoOcupacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historico")
@RequiredArgsConstructor
@CrossOrigin
public class CirurgiaStatusController {

    private final HistoricoOcupacaoService historicoOcupacaoService;

    @GetMapping("/status")
    public List<HistoricoCompletoDTO> listarStatusCirurgias() {
        return historicoOcupacaoService.listarHistoricoCompleto();
    }
}

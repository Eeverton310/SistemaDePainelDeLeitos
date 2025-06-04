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
public class HistoricoOcupacaoController {

    private final HistoricoOcupacaoService historicoOcupacaoService;

    @GetMapping
    public List<HistoricoCompletoDTO> listar() {
        return historicoOcupacaoService.listarHistoricoCompleto();
    }
}

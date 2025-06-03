package com.HospitalDecos.SistemaDePainelDeLeitos.controller;

import com.HospitalDecos.SistemaDePainelDeLeitos.dto.CirurgiaStatusDTO;
import com.HospitalDecos.SistemaDePainelDeLeitos.service.CirurgiaStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cirurgias")
@RequiredArgsConstructor
@CrossOrigin
public class CirurgiaStatusController {

    private final CirurgiaStatusService cirurgiaStatusService;

    @GetMapping("/status")
    public List<CirurgiaStatusDTO> listarStatusCirurgias() {
        return cirurgiaStatusService.listarStatusCirurgias();
    }
}

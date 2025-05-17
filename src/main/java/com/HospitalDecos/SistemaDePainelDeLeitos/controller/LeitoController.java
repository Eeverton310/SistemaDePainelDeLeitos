package com.HospitalDecos.SistemaDePainelDeLeitos.controller;

import com.HospitalDecos.SistemaDePainelDeLeitos.model.Leito;
import com.HospitalDecos.SistemaDePainelDeLeitos.service.LeitoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/leitos")
@CrossOrigin
public class LeitoController {
    private final LeitoService service;
    public LeitoController(LeitoService service) { this.service = service; }
    @GetMapping
    public List<Leito> getAll() { return service.listarTodos(); }
}

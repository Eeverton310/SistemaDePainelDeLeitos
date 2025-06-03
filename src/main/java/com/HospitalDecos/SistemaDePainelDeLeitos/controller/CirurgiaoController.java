package com.HospitalDecos.SistemaDePainelDeLeitos.controller;
import com.HospitalDecos.SistemaDePainelDeLeitos.model.Cirurgiao;
import com.HospitalDecos.SistemaDePainelDeLeitos.service.CirurgiaoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cirurgiao")
@CrossOrigin
public class CirurgiaoController {

    private final CirurgiaoService service;

    public CirurgiaoController(CirurgiaoService service) {
        this.service = service;

    }@GetMapping
    public List<Cirurgiao> getAll() { return service.listarTodos(); }

}

package com.HospitalDecos.SistemaDePainelDeLeitos.service;

import com.HospitalDecos.SistemaDePainelDeLeitos.model.Leito;
import com.HospitalDecos.SistemaDePainelDeLeitos.repository.LeitoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeitoService {
    private final LeitoRepository repo;
    public LeitoService(LeitoRepository repo) { this.repo = repo; }
    public List<Leito> listarTodos() { return repo.findAll(); }
}

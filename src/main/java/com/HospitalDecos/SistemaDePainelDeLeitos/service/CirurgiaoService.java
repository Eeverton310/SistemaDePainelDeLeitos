package com.HospitalDecos.SistemaDePainelDeLeitos.service;

import com.HospitalDecos.SistemaDePainelDeLeitos.model.Cirurgiao;
import com.HospitalDecos.SistemaDePainelDeLeitos.repository.CirurgiaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CirurgiaoService {
    private final CirurgiaoRepository repo;
    public CirurgiaoService(CirurgiaoRepository repo) { this.repo = repo; }
    public List<Cirurgiao> listarTodos() { return repo.findAll(); }
}

package com.example.tprime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tprime.model.Compra;
import com.example.tprime.repository.ICompraRepository;
import java.util.*;

@Service
public class CompraService {
    @Autowired
    private ICompraRepository repository;

    public void salvar(Compra compra) {
        repository.save(compra);
    }

    public void editar(Compra compra) {
        repository.save(compra);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Optional<Compra> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Compra> buscarTodos() {
        return repository.findAll();
    }

}

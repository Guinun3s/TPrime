package com.example.tprime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tprime.model.Pagamento;
import com.example.tprime.repository.IPagamentoRepository;
import java.util.*;

@Service
public class PagamentoService {
    @Autowired
    private IPagamentoRepository repository;

    public void salvar(Pagamento pagamento) {
        repository.save(pagamento);
    }

    public void editar(Pagamento pagamento) {
        repository.save(pagamento);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Optional<Pagamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Pagamento> buscarTodos() {
        return repository.findAll();
    }

}

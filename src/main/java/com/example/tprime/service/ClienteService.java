package com.example.tprime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tprime.model.Cliente;
import com.example.tprime.repository.IClienteRepository;
import java.util.*;

@Service
public class ClienteService {
    @Autowired
    private IClienteRepository repository;

    public void salvar(Cliente cliente){
        repository.save(cliente);
    }

    public void editar(Cliente cliente){
        repository.save(cliente);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    public Optional<Cliente> buscarPorId(Long id){
        return repository.findById(id);
    }

    public List<Cliente> buscarTodos(){
        return repository.findAll();
    }
}
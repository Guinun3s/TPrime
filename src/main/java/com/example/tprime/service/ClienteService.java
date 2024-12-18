package com.example.tprime.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tprime.model.Cliente;
import com.example.tprime.model.Compra;
import com.example.tprime.repository.IClienteRepository;
import com.example.tprime.repository.ICompraRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ClienteService {
    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ICompraRepository compraRepository;

    //Método utilizado para o adicionar a dívida do cliente caso ele não pague a sua compra
    public void adicionarDivida(Long clienteId, Long compraId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Compra compra = compraRepository.findById(compraId).orElseThrow(() -> new RuntimeException("Compra não encontrada"));

        if (!compra.isSituacao()) {
            // Adicionar o valor da compra à dívida do cliente
            cliente.setDivida(cliente.getDivida() + compra.getValor());
            clienteRepository.save(cliente);
        }
    }

    public void salvar(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void editar(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void excluir(Long id){
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }
}

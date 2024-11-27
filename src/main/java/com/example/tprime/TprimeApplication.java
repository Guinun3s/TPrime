package com.example.tprime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.tprime.repository.IClienteRepository;
import com.example.tprime.repository.ICompraRepository;
import com.example.tprime.repository.IPagamentoRepository;
import com.example.tprime.repository.IProdutoRepository;

@SpringBootApplication
public class TprimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TprimeApplication.class, args);
	}

	@Bean
	public CommandLineRunner tprime(IClienteRepository cliRep, ICompraRepository comRep, 
	IPagamentoRepository pagRep, IProdutoRepository proRep){ 
		return (args) -> {
	
		};

	}
}

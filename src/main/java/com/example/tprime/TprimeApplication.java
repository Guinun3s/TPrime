package com.example.tprime;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.tprime.model.Cliente;
import com.example.tprime.model.Compra;
import com.example.tprime.model.Pagamento;
import com.example.tprime.model.Produto;
import com.example.tprime.service.ClienteService;
import com.example.tprime.service.CompraService;
import com.example.tprime.service.PagamentoService;
import com.example.tprime.service.ProdutoService;

@SpringBootApplication
public class TprimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TprimeApplication.class, args);
	}

	//Local onde os dados seram adicionados no banco de dados
	@Bean
	public CommandLineRunner tprime(ClienteService cliService, CompraService comService, 
	PagamentoService pagService, ProdutoService proService){ 
		return (args) -> {
			//O primeiro exemplo representa uma compra não paga
			Cliente c1 = new Cliente();
			Compra co1 = new Compra();
			Produto p1 = new Produto();
			
			c1.setNome("João");
			c1.setCpf("1111111111");
			c1.setDataNas(LocalDate.of(1999, 9, 12));
			c1.setEmail("joão@gmail.com");
			c1.setDivida(0);
			c1.setEndereco("Rua Alameda");
			c1.setTelefone("7799999999");
			cliService.salvar(c1);

			p1.setNome("Perfume");
			p1.setValor(50);
			proService.salvar(p1);

			co1.setCliente(c1);
			co1.setProduto(p1);
			co1.setDataCompra(LocalDate.of(2024, 11, 28));
			co1.setValor(p1.getValor());
			co1.setSituacao(false);
			comService.salvar(co1);

			//Adicionando a divida do cliente no banco de dados
			cliService.adicionarDivida((long) 1, (long) 1);

			/*pa1.setCompra(co1);
			pa1.setValor(co1.getValor());
			pa1.setFormaPagamento("Pix");
			pa1.setDataPagamento(co1.getDataCompra());
			pagService.pagarCompra((long) 1, (long) 1);
			pagService.salvar(pa1);*/

			//O segundo exemplo representa uma compra paga
			Cliente c2 = new Cliente();
			Compra co2 = new Compra();
			Produto p2 = new Produto();
			Pagamento pa2 = new Pagamento();

			c2.setNome("Raul");
			c2.setCpf("2222222222");
			c2.setDataNas(LocalDate.of(2002, 2, 23));
			c2.setEmail("Raul@gmail.com");
			c2.setDivida(0);
			c2.setEndereco("Rua Chama");
			c2.setTelefone("77988888888");
			cliService.salvar(c2);

			p2.setNome("Perfume");
			p2.setValor(100);
			proService.salvar(p2);

			co2.setCliente(c2);
			co2.setProduto(p2);
			co2.setDataCompra(LocalDate.of(2024, 11, 28));
			co2.setValor(p2.getValor());
			co2.setSituacao(true);
			comService.salvar(co2);

			cliService.adicionarDivida((long) 2, (long) 2);
	
			pa2.setCompra(co2);
			pa2.setValor(co2.getValor());
			pa2.setFormaPagamento("Pix");
			pa2.setDataPagamento(co2.getDataCompra());

			//Método utilizado para atribuir o pagamento do cliente
			pagService.pagarCompra((long) 2, (long) 2);
			pagService.salvar(pa2);
		};

	}
}

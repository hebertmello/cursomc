package com.hfdm.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hfdm.cursomc.domain.Categoria;
import com.hfdm.cursomc.domain.Cidade;
import com.hfdm.cursomc.domain.Cliente;
import com.hfdm.cursomc.domain.Endereco;
import com.hfdm.cursomc.domain.Estado;
import com.hfdm.cursomc.domain.Produto;
import com.hfdm.cursomc.domain.enums.TipoCliente;
import com.hfdm.cursomc.repositories.CategoriaRepository;
import com.hfdm.cursomc.repositories.CidadeRepository;
import com.hfdm.cursomc.repositories.ClienteRepository;
import com.hfdm.cursomc.repositories.EnderecoRepository;
import com.hfdm.cursomc.repositories.EstadoRepository;
import com.hfdm.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria();
		categoria1.setNome("Informática");

		Categoria categoria2 = new Categoria();
		categoria2.setNome("Escritório");

		Produto produto1 = new Produto();
		produto1.setNome("Computador");
		produto1.setPreco(2000.00);
		produto1.addCategoria(categoria1);

		Produto produto2 = new Produto();
		produto2.setNome("Impressora");
		produto2.setPreco(800.00);
		produto2.addCategoria(categoria1);
		produto2.addCategoria(categoria2);

		Produto produto3 = new Produto();
		produto3.setNome("Mouse");
		produto3.setPreco(80.00);
		produto3.addCategoria(categoria1);

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

		Estado estado1 = new Estado();
		estado1.setNome("Minas Gerais");

		Estado estado2 = new Estado();
		estado2.setNome("São Paulo");

		Cidade cidade1 = new Cidade();
		cidade1.setNome("Uberlândia");
		cidade1.setEstado(estado1);

		Cidade cidade2 = new Cidade();
		cidade2.setNome("São Paulo");
		cidade2.setEstado(estado2);

		Cidade cidade3 = new Cidade();
		cidade3.setNome("Campinas");
		cidade3.setEstado(estado2);

		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));

		Cliente cliente1 = new Cliente();
		cliente1.setNome("Maria Silva");
		cliente1.setEmail("maria@gmail.com");
		cliente1.setCpfOuCnpj("36378912377");
		cliente1.setTipo(TipoCliente.PESSOAFISICA);

		cliente1.addTelefone("27363323");
		cliente1.addTelefone("93838393");

		Endereco endereco1 = new Endereco();
		endereco1.setLogradouro("Rua Flores");
		endereco1.setNumero("300");
		endereco1.setComplemento("Apto 303");
		endereco1.setBairro("Jardim");
		endereco1.setCep("38220834");
		endereco1.setCliente(cliente1);
		endereco1.setCidade(cidade1);

		Endereco endereco2 = new Endereco();
		endereco2.setLogradouro("Avenida Matos");
		endereco2.setNumero("105");
		endereco2.setComplemento("Sala 800");
		endereco2.setBairro("Centro");
		endereco2.setCep("38777012");
		endereco2.setCliente(cliente1);
		endereco2.setCidade(cidade2);

		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
	}

}

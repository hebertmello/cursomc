package com.hfdm.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hfdm.cursomc.domain.Categoria;
import com.hfdm.cursomc.domain.Produto;
import com.hfdm.cursomc.repositories.CategoriaRepository;
import com.hfdm.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

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
	}

}

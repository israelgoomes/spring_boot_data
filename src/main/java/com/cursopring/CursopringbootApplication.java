package com.cursopring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursopring.dao.CategoriaDAO;
import com.cursopring.dao.CidadeDAO;
import com.cursopring.dao.ClienteDAO;
import com.cursopring.dao.EnderecoDAO;
import com.cursopring.dao.EstadoDAO;
import com.cursopring.dao.ProdutoDAO;
import com.cursopring.domain.Categoria;
import com.cursopring.domain.Cidade;
import com.cursopring.domain.Cliente;
import com.cursopring.domain.Endereco;
import com.cursopring.domain.Estado;
import com.cursopring.domain.Produto;
import com.cursopring.domain.enums.TipoCliente;

@SpringBootApplication
public class CursopringbootApplication implements CommandLineRunner{

	@Autowired
	private CategoriaDAO categoriaDao;
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@Autowired
	private CidadeDAO cidadeDao;
	
	@Autowired
	private ClienteDAO clienteDao;
	
	@Autowired
	private EnderecoDAO enderecoDao;
	
	@Autowired EstadoDAO estadoDao;

	
	public static void main(String[] args) {
		SpringApplication.run(CursopringbootApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 200.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaDao.saveAll(Arrays.asList(cat1, cat2));
		produtoDao.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlâncida", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		
		estadoDao.saveAll(Arrays.asList(est1, est2));
		cidadeDao.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("2763323", "9383893"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida MAtos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteDao.saveAll(Arrays.asList(cli1));
		enderecoDao.saveAll(Arrays.asList(e1, e2));
		
		
		
		
		
	}

}

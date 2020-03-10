package com.cursopring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursopring.dao.CategoriaDAO;
import com.cursopring.domain.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaDAO repo;	
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
}

package com.cursopring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursopring.dao.CategoriaDAO;
import com.cursopring.domain.Categoria;

import com.cursopring.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaDAO repo;	
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado! id: " + id + ", Tipo " + Categoria.class.getName()));
		
		
	}
}

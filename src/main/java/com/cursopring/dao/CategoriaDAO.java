package com.cursopring.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursopring.domain.Categoria;

@Repository
public interface CategoriaDAO extends JpaRepository<Categoria, Integer>{

}

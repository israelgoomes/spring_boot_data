package com.cursopring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursopring.domain.Produto;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Integer>{

}

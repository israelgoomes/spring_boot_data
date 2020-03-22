package com.cursopring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursopring.domain.Cidade;

@Repository
public interface CidadeDAO extends JpaRepository<Cidade, Integer>{

}

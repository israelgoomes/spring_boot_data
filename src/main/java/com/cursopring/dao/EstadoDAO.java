package com.cursopring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursopring.domain.Estado;

@Repository
public interface EstadoDAO extends JpaRepository<Estado, Integer>{

}

package com.compass.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compass.apirest.modelo.Estado;
import com.compass.apirest.modelo.Regioes;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

	List<Estado> findByRegiao(Regioes regiao);
	

}

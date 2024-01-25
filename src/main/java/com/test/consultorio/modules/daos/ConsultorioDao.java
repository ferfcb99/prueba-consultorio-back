package com.test.consultorio.modules.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.consultorio.modules.entities.Consultorio;

@Repository
public interface ConsultorioDao extends JpaRepository<Consultorio, Long>{

	@Query("SELECT c FROM Consultorio c WHERE c.id = :id")
	public Consultorio getById(@PathVariable Long id);
	
}

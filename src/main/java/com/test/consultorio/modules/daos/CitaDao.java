package com.test.consultorio.modules.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.consultorio.modules.entities.Cita;

public interface CitaDao extends JpaRepository<Cita, Long>{
	
	@Query("SELECT c FROM Cita c WHERE c.id = :id")
	public Cita getById(@PathVariable Long id);

}

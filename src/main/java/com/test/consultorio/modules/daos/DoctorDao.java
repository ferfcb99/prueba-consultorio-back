package com.test.consultorio.modules.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.consultorio.modules.entities.Doctor;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Long>{

	@Query("SELECT d FROM Doctor d WHERE d.id = :id")
	public Doctor getById(@PathVariable Long id);
	
}

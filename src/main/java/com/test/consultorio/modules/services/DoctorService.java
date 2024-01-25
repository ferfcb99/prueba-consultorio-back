package com.test.consultorio.modules.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.consultorio.modules.daos.DoctorDao;
import com.test.consultorio.modules.entities.Doctor;
import com.test.consultorio.modules.interfaces.IGeneralService;

@Service
public class DoctorService implements IGeneralService<Doctor>{
	
	@Autowired
	private DoctorDao doctorDao;

	@Override
	public List<Doctor> findAll() {
		List<Doctor> doctores = this.doctorDao.findAll();
		return doctores;
	}

	@Override
	public Doctor getById(Long id) {
		Doctor doctor = this.doctorDao.getById(id);
		return doctor;
	}

	@Override
	public Doctor create(Doctor entity) {

		try {
			Doctor doctor = this.doctorDao.save(entity);
			if(doctor != null) {
				return doctor;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Doctor update(Doctor entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor deleteById(Long id) {
		Doctor doctor = getById(id);
		try {
			this.doctorDao.deleteById(id);
			return doctor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}

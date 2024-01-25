package com.test.consultorio.modules.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.consultorio.modules.daos.ConsultorioDao;
import com.test.consultorio.modules.entities.Consultorio;
import com.test.consultorio.modules.interfaces.IGeneralService;

@Service
public class ConsultorioService implements IGeneralService<Consultorio>{

	@Autowired
	private ConsultorioDao consultorioDao;

	@Override
	public List<Consultorio> findAll() {
		List<Consultorio> consultorios = this.consultorioDao.findAll();
		return consultorios;
	}

	@Override
	public Consultorio getById(Long id) {
		Consultorio consultorio = this.consultorioDao.getById(id);
		return consultorio;
	}

	@Override
	public Consultorio create(Consultorio entity) {

		try {
			Consultorio consultorio = this.consultorioDao.save(entity);
			if(consultorio != null) {
				return consultorio;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Consultorio update(Consultorio entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consultorio deleteById(Long id) {
		Consultorio consultorio = getById(id);
		try {
			this.consultorioDao.deleteById(id);
			return consultorio;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}

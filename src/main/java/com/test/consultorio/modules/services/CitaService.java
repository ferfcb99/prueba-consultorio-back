package com.test.consultorio.modules.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.consultorio.modules.daos.CitaDao;
import com.test.consultorio.modules.daos.ConsultorioDao;
import com.test.consultorio.modules.daos.DoctorDao;
import com.test.consultorio.modules.entities.Cita;
import com.test.consultorio.modules.entities.Consultorio;
import com.test.consultorio.modules.entities.Doctor;
import com.test.consultorio.modules.interfaces.IGeneralService;

@Service
public class CitaService implements IGeneralService<Cita>{

	@Autowired
	private CitaDao citaDao;
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private ConsultorioDao consultorioDao;



	@Override
	public List<Cita> findAll() {
		List<Cita> citasObtenidas = this.citaDao.findAll();
		
		List<Cita> citasEntregables = new ArrayList<>();
		
		citasObtenidas.forEach(cita -> {
			citasEntregables.add(cita);
		});
		return citasEntregables;
	}

	@Override
	public Cita getById(Long id) {
		Cita citaObtenida = this.citaDao.getById(id);
		
		if(citaObtenida == null) {
			return null;
		}
		
		Cita citaEntregable = new Cita(citaObtenida.getId(),
				citaObtenida.getConsultorio(), 
				citaObtenida.getDoctor(),
				citaObtenida.getHorario_consulta(), 
				citaObtenida.getNombre_paciente());
		
		return citaEntregable;
	}

	@Override
	public Cita create(Cita entity) {
		
		String horario = entity.getHorario_consulta();
		List<Cita> citasObtenidas = findAll();
		for (Cita cita : citasObtenidas) {
			if(cita.getHorario_consulta().equals(horario)) {
				return null;
			}
		}
		
		List<Consultorio> consultorios = this.consultorioDao.findAll();
		for (Cita cita : citasObtenidas) {
			if(consultorios.contains(cita.getConsultorio())) {
				return null;
			}
		}
		
		List<Doctor> doctores = this.doctorDao.findAll();
		for (Cita cita : citasObtenidas) {
			if(doctores.contains(cita.getDoctor()) && cita.getHorario_consulta().equals(horario)) {
				return null;
			}
		}
		
	
		try {
			Cita citaCreada = this.citaDao.save(entity);
			if(citaCreada != null) {
				return citaCreada;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Cita update(Cita entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cita deleteById(Long id) {
		Cita citaAEliminar = getById(id);
		try {
			this.citaDao.deleteById(id);
			return citaAEliminar;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}

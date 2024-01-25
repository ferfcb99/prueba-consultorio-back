package com.test.consultorio.modules.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.consultorio.modules.entities.Doctor;
import com.test.consultorio.modules.interfaces.IGeneralController;
import com.test.consultorio.modules.services.DoctorService;
import com.test.consultorio.shared.models.ResponseApi;

@RestController()
@RequestMapping(value = "/doctores")
public class DoctorController implements IGeneralController<Doctor>{

	@Autowired
	private DoctorService doctorService;
	
	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseApi<List<Doctor>>> findAll() {
		return ResponseEntity
				.ok(new ResponseApi<>(String.valueOf(HttpStatus.OK),this.doctorService.findAll(),"Operacion realizada"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseApi<Doctor>> getById(@PathVariable Long id) {
		return ResponseEntity
				.ok(new ResponseApi<>(String.valueOf(HttpStatus.OK),this.doctorService.getById(id),"Operacion realizada"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseApi<Doctor>> create(@RequestBody Doctor entity) {
		return ResponseEntity
				.ok(new ResponseApi<>(String.valueOf(HttpStatus.OK),this.doctorService.create(entity),"Operacion realizada"));
	}

	@Override
	public ResponseEntity<ResponseApi<Doctor>> update(@RequestBody Doctor entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseApi<Doctor>> deleteById(@PathVariable Long id) {
		return ResponseEntity
				.ok(new ResponseApi<>(String.valueOf(HttpStatus.OK),this.doctorService.deleteById(id),"Operacion realizada"));
	}
	
	

}

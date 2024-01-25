package com.test.consultorio.modules.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.consultorio.modules.entities.Cita;
import com.test.consultorio.modules.interfaces.IGeneralController;
import com.test.consultorio.modules.services.CitaService;
import com.test.consultorio.shared.models.ResponseApi;

@RestController()
@RequestMapping(value = "/citas")
@CrossOrigin(origins = "http://localhost:4200/")
public class CitaController implements IGeneralController<Cita>{

	@Autowired
	private CitaService citaService;
	
	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseApi<List<Cita>>> findAll() {
		return ResponseEntity
				.ok(new ResponseApi<>(String.valueOf(HttpStatus.OK),this.citaService.findAll(),"Operacion realizada"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseApi<Cita>> getById(@PathVariable Long id) {
		return ResponseEntity
				.ok(new ResponseApi<>(String.valueOf(HttpStatus.OK),this.citaService.getById(id),"Operacion realizada"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseApi<Cita>> create(@RequestBody Cita entity) {
		return ResponseEntity
				.ok(new ResponseApi<>(String.valueOf(HttpStatus.OK),this.citaService.create(entity),"Operacion realizada"));
	}

	@Override
	public ResponseEntity<ResponseApi<Cita>> update(@RequestBody Cita entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseApi<Cita>> deleteById(@PathVariable Long id) {
		return ResponseEntity
				.ok(new ResponseApi<>(String.valueOf(HttpStatus.OK),this.citaService.deleteById(id),"Operacion realizada"));
	}

	

}

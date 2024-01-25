package com.test.consultorio.modules.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.test.consultorio.shared.models.ResponseApi;

public interface IGeneralController<T> {

	public ResponseEntity<ResponseApi<List<T>>> findAll();
	
	public ResponseEntity<ResponseApi<T>> getById(Long id);
	
	public ResponseEntity<ResponseApi<T>> create(T entity);
	
	public ResponseEntity<ResponseApi<T>> update(T entity);
	
	public ResponseEntity<ResponseApi<T>> deleteById(Long id);
	
}

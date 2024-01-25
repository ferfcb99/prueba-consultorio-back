package com.test.consultorio.modules.interfaces;

import java.util.List;

public interface IGeneralService<T> {

	public List<T> findAll();
	
	public T getById(Long id);
	
	public T create(T entity);
	
	public T update(T entity);
	
	public T deleteById(Long id);
	
}

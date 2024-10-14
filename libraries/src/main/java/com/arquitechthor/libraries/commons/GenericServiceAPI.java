package com.arquitechthor.libraries.commons;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericServiceAPI<T, ID extends Serializable> {

	T save(T entity);
	
	void delete(ID id);
	
	Optional<T> get(ID id);
	
	List<T> getAll();
}

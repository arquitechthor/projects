package com.arquitechthor.libraries.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> 
	implements GenericServiceAPI<T, ID> {

	@Override
	public T save(T entity) {
		return repository().save(entity);
	}

	@Override
	public void delete(ID id) {
		repository().deleteById(id);
	}

	@Override
	public Optional<T> get(ID id) {
		return repository().findById(id);
	}

	@Override
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		repository().findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}

	public abstract CrudRepository<T, ID> repository();

}

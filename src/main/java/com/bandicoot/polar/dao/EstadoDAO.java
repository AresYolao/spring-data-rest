package com.bandicoot.polar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.bandicoot.polar.model.Estado;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "estados", path = "estados")
public interface EstadoDAO extends CrudRepository<Estado, Long> {

	@Override
	@RestResource(exported = false)
	void deleteById(Long aLong);

	@Override
	@RestResource(exported = false)
	void delete(Estado entity);

	@Override
	@RestResource(exported = false)
	Estado save(Estado entity);
}
package com.bandicoot.polar.dao;

import org.springframework.data.repository.CrudRepository;

import com.bandicoot.polar.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Long>{

}

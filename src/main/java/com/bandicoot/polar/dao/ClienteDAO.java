package com.bandicoot.polar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.bandicoot.polar.model.Cliente;

@CrossOrigin
@RepositoryRestResource
public interface ClienteDAO extends JpaRepository<Cliente, Long> {

}
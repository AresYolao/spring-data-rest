package com.bandicoot.polar.service;

import java.util.List;

import com.bandicoot.polar.dto.ClienteDTO;

public interface ClienteService {

	    List<ClienteDTO> getClientes();
	    
	    ClienteDTO getClienteById(Long id);

	    ClienteDTO createCliente(ClienteDTO clienteDTO);

}

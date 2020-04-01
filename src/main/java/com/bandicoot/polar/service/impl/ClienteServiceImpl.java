package com.bandicoot.polar.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bandicoot.polar.dto.ClienteDTO;
import com.bandicoot.polar.dto.Response;
import com.bandicoot.polar.repository.ClienteRepository;
import com.bandicoot.polar.service.ClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService{

	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<ClienteDTO> getClientes() {
		Response<ClienteDTO> clienteResponse = clienteRepository.getClientes();
		return clienteResponse.getData().get("clientes");

	}

	@Override
	public ClienteDTO getClienteById(Long id) {
		
		ClienteDTO clienteDTO = clienteRepository.getClienteById(id);
        return clienteDTO;

	}

	@Override
	public ClienteDTO createCliente(ClienteDTO clienteDTO) {
		System.out.println("Entrando a crear cliente");
		clienteDTO.setFechaCreacion(new Date());
		log.info(">>> Crea clienteDTO :{}", getJson(clienteDTO));
		ClienteDTO cliente = clienteRepository.createCliente(clienteDTO);
		log.info(">>> Crea cliente :{}", getJson(clienteDTO));
		clienteDTO.setId(cliente.getIdCliente());
		clienteDTO.setIdCliente(cliente.getIdCliente());
		
//		log.info(">>> Campo creado! ID: " + campoDTO.getIdCampo() + " Nombre:{} " + campoDTO.getNombre());
	
	return clienteDTO;
	}

	private String getJson(Object object) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException exception) {
			log.error("ERROR {}", exception);
		}
		return null;
	}

}

package com.bandicoot.polar.repository;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bandicoot.polar.dto.ClienteDTO;
import com.bandicoot.polar.dto.Response;

@RequestMapping("${api.components.root.path}")
@Component(value = "clienteRepository")
public interface ClienteRepository {

    @GetMapping(path = "${api.components.cliente.path}")
    Response<ClienteDTO> getClientes();
    
    @GetMapping("${api.components.cliente.path}/{id}")
    ClienteDTO getClienteById(@PathVariable("id") Long id);


    @PostMapping(path = "${api.components.cliente.path}")
    ClienteDTO createCliente(@RequestBody ClienteDTO clienteDTO);

}

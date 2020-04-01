package com.bandicoot.polar.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

	    private Long id;

	    private Long idCliente;

	    private String nombre;

		private String apellido;
		
		private String email;
		
		private Date fechaCreacion;

}

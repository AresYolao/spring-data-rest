package com.bandicoot.polar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido_paterno")
	private String apellidoPaterno;
	
	@Column(name = "apellido_materno")
	private String apellidoMaterno;
	
	@Column(name = "telefono")
	private Long telefono;
	
	@Column(name = "email",nullable = false, unique = true)
	private String email;
	
	@Column(name = "estatus")
	private Boolean estatus;
	
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	@ManyToOne
    @JoinColumn(name = "estado_id",nullable = true, updatable = true, insertable = true)
	private Estado estado;
	
	public Long getIdCliente() {
		return id;
	}

	
	public Estado getDataEstado() {
		return estado;
	}
	
	public void setDataEstado(Estado dataEstado) {
		this.estado = dataEstado;
	}
	
}

package com.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProveedorDTO implements Serializable {

	private static final long serialVersionUID = 2L;
	private int id;
	private String nombre;
	private Date fechaAlta;
	private int idCliente;
	
}

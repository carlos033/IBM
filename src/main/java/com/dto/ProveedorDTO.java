package com.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "Proveedor", description = "Proveedores de la empresa")
public class ProveedorDTO implements Serializable {

	private static final long serialVersionUID = 2L;
	private int id;
	private String nombre;
	private Date fechaAlta;
	private int idCliente;

}

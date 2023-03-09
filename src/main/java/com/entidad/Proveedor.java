package com.entidad;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@Entity
@NoArgsConstructor
public class Proveedor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Schema(name = "id", description = "id Proveedor", example = "1")
	private int id;
	@NotBlank
	@Schema(name = "nombre", description = "", example = "Coca-Cola")
	private String nombre;	
	private LocalDate fechaAlta;
	@NotNull
	@Schema(name = "idCliente", description = "identificador del cliente", example = "11")
	private int idCliente;

	public Proveedor(String nombre, LocalDate fechaAlta, int idCliente) {
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "" + id + "\t   " + nombre + "\t    " + fechaAlta + "\t      " + idCliente;
	}
}

package com.entidad;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	private int id;
	private String nombre;
	private LocalDate fechaAlta;
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

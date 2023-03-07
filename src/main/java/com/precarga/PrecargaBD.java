/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.precarga;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.entidad.Proveedor;
import com.excepciones.ExcepcionServicio;
import com.servicio.ServicioProveedorImpl;

/**
 *
 * @author ck
 */
@Component
public class PrecargaBD {
	@Autowired
	private ServicioProveedorImpl servicio;

	@Transactional
	public void precargarBaseDeDatos() throws ExcepcionServicio {
		try {
			servicio.busacrXid(1);
		} catch (ExcepcionServicio ex) {
			LocalDate fecha = LocalDate.of(2019, 01, 10);
			Proveedor proveedor1 = new Proveedor("CocaCola", fecha, 2);
			LocalDate fecha2 = LocalDate.of(2019, 02, 10);
			Proveedor proveedor2 = new Proveedor("Neslet", fecha2, 2);
			LocalDate fecha3 = LocalDate.of(2019, 03, 10);
			Proveedor proveedor3 = new Proveedor("Pepsi", fecha3, 1);
			Proveedor proveedor4 = new Proveedor("CocaCola", fecha, 1);
			Proveedor proveedor5 = new Proveedor("Lindor", fecha2, 3);
			servicio.crearProveedor(proveedor5);
			servicio.crearProveedor(proveedor4);
			servicio.crearProveedor(proveedor3);
			servicio.crearProveedor(proveedor2);
			servicio.crearProveedor(proveedor1);
		}
	}

}

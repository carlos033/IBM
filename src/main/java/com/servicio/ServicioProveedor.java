package com.servicio;

import java.io.IOException;
import java.util.List;

import com.entidad.Proveedor;
import com.excepciones.ExcepcionServicio;

public interface ServicioProveedor {
	public List<Proveedor> buscaquedaXIdCliente(int idCliente) throws ExcepcionServicio, IOException;

	public Proveedor busacrXid(int id) throws ExcepcionServicio;

	public void crearProveedor(Proveedor entidad) throws ExcepcionServicio;
}

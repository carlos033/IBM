package com.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entidad.Proveedor;
import com.excepciones.ExcepcionServicio;
import com.repositorio.ProveedorRepository;

@Service
public class ServicioProveedorImpl implements ServicioProveedor {
	@Autowired
	private ProveedorRepository repositorio;

	@Override
	public List<Proveedor> buscaquedaXIdCliente(int idCliente) throws ExcepcionServicio {
		List<Proveedor> listaProveedores = repositorio.findProveedoresByIdCliente(idCliente);
		if (listaProveedores.size() == 0) {
			throw new ExcepcionServicio("No existen proveedores con ese Id del cliente");
		}
		return listaProveedores;
	}

	@Override
	public void crearProveedor(Proveedor entidad) throws ExcepcionServicio {
		repositorio.save(entidad);

	}

	@Override
	public List<Proveedor> todas() {
		List<Proveedor> listaProvedores = repositorio.findAll();
		return listaProvedores;
	}

}

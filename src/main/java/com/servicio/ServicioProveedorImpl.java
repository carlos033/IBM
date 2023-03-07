package com.servicio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	public List<Proveedor> buscaquedaXIdCliente(int idCliente) throws ExcepcionServicio, IOException {
		List<Proveedor> listaProveedores = repositorio.findProveedoresByIdCliente(idCliente);
		if (listaProveedores.size() == 0) {
			throw new ExcepcionServicio("No existen proveedores con ese Id del cliente");
		} else {
			crearFichero(listaProveedores);
		}
		return listaProveedores;
	}

	@Override
	public void crearProveedor(Proveedor entidad) throws ExcepcionServicio {
		repositorio.save(entidad);

	}

	@Override
	public Proveedor busacrXid(int id) throws ExcepcionServicio {
		Proveedor proveedor = repositorio.findById(id).orElse(null);
		if (proveedor == null) {
			throw new ExcepcionServicio("No existen proveedores con ese Id del cliente");
		}
		return proveedor;
	}

	public void crearFichero(List<Proveedor> listaProveedores) throws IOException {
		FileWriter fichero = new FileWriter("Resultado.txt");
		try {
			BufferedWriter bw = new BufferedWriter(fichero);
			bw.write("id \t   nombre \t    fecha alta \t  idCliente \t \n");
			for (Proveedor proveedor : listaProveedores) {
				bw.write(proveedor.toString() + "\n");
			}
			bw.close();
			fichero.close();
		} catch (IOException ex) {
			throw new IOException(ex.getMessage());
		}
	}
}

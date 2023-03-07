package com.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.dto.ProveedorDTO;
import com.excepciones.ExcepcionServicio;
import com.mapper.MapperProveedor;
import com.servicio.ServicioProveedor;

@Controller
public class Controlador {
	@Autowired
	private ServicioProveedor servicio;
	@Autowired
	private MapperProveedor mapper;

	@GetMapping("/proveedores/{id}")
	@ResponseBody
	public ResponseEntity<List<ProveedorDTO>> listarProveedoresXCliente(@PathVariable("id") int idCliente) {
		try {
			return new ResponseEntity<List<ProveedorDTO>>(servicio.buscaquedaXIdCliente(idCliente).stream()
					.map(mapper::mapeoADTO).collect(Collectors.toList()), HttpStatus.OK);
		} catch (ExcepcionServicio e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
		}

	}

	@GetMapping("/listar")
	@ResponseBody
	public ResponseEntity<List<ProveedorDTO>> listarTodos() {
		return new ResponseEntity<List<ProveedorDTO>>(
				servicio.todas().stream().map(mapper::mapeoADTO).collect(Collectors.toList()), HttpStatus.OK);
	}
}

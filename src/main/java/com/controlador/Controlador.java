package com.controlador;

import java.io.IOException;
import java.util.ArrayList;
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

	@GetMapping("/proveedores/{idC}")
	@ResponseBody
	public ResponseEntity<List<ProveedorDTO>> listarProveedoresXCliente(@PathVariable("idC") int idCliente) {
		List<ProveedorDTO> listaDTO = new ArrayList<>();
		try {
			listaDTO = servicio.buscaquedaXIdCliente(idCliente).stream().map(mapper::mapeoADTO)
					.collect(Collectors.toList());
		} catch (ExcepcionServicio e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<ProveedorDTO>>(listaDTO, HttpStatus.OK);
	}
}

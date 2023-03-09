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
import com.entidad.Proveedor;
import com.excepciones.ExcepcionServicio;
import com.mapper.MapperProveedor;
import com.servicio.ServicioProveedor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Controller
public class Controlador {
	@Autowired
	private ServicioProveedor servicio;
	@Autowired
	private MapperProveedor mapper;

	@Operation(description = "Obtener todos los proveedores por id de cliente")
	@ApiResponse(responseCode = "200", description = "Operacion satisfactoria", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Proveedor.class))))
	@ApiResponse(responseCode = "401", description = "No autorizado")
	@ApiResponse(responseCode = "403", description = "Acceso prohibido")
	@ApiResponse(responseCode = "404", description = "No encontrado")
	@GetMapping("/proveedores/{idC}")
	@ResponseBody
	public ResponseEntity<List<ProveedorDTO>> listarProveedoresXCliente(@PathVariable("idC ")  @Parameter(description=" Id de cliente") int idCliente) {
		List<ProveedorDTO> listaDTO = new ArrayList<>();
		try {
			listaDTO = servicio.buscaquedaXIdCliente(idCliente).stream().map(mapper::mapeoADTO)
					.collect(Collectors.toList());
		} catch (ExcepcionServicio e) {
			if (e.getMessage().contains("Ha ocurrido una")) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			} else {
				throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<ProveedorDTO>>(listaDTO, HttpStatus.OK);
	}
}

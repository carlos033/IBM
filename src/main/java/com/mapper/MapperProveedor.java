package com.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.dto.ProveedorDTO;
import com.entidad.Proveedor;

@Mapper(componentModel = "spring")
public interface MapperProveedor {
	Proveedor mapeoAEntidad(ProveedorDTO dTO);

	ProveedorDTO mapeoADTO(Proveedor entidad);

	List<ProveedorDTO> mapeoListaADTO(List<Proveedor> listaProveedor);
}

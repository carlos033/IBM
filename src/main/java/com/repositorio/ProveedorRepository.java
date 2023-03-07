package com.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.entidad.Proveedor;

@EnableJpaRepositories
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
	@Query(value = "Select p FROM Proveedor p WHERE p.idCliente =: idCliente")
	List<Proveedor> findProveedoresByIdCliente(@Param("idCliente") int idCliente);
}

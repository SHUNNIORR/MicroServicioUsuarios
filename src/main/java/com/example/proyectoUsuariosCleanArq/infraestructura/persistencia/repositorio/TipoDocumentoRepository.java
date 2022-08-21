package com.example.proyectoUsuariosCleanArq.infraestructura.persistencia.repositorio;

import com.example.proyectoUsuariosCleanArq.infraestructura.persistencia.entidad.TipoDocumentoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntidad,Integer> {
}

package com.example.proyectoUsuariosCleanArq.infraestructura.persistencia.repositorio;

import com.example.proyectoUsuariosCleanArq.infraestructura.persistencia.entidad.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntidad,Long> {
}

package com.example.proyectoUsuariosCleanArq.dominio.useCase.servicio;

import com.example.proyectoUsuariosCleanArq.dominio.modelo.ResponseDto;
import com.example.proyectoUsuariosCleanArq.dominio.modelo.UsuarioDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioDao {
    List<UsuarioDto> getUsuarios();

    UsuarioDto getUsuarioById(Long id);

    ResponseEntity<ResponseDto> deleteUsuarioById(Long id);

    ResponseEntity<ResponseDto> saveUsuario(UsuarioDto usuario);
}

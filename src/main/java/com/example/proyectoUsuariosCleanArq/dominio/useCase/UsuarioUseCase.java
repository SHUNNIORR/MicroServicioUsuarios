package com.example.proyectoUsuariosCleanArq.dominio.useCase;

import com.example.proyectoUsuariosCleanArq.dominio.modelo.ResponseDto;
import com.example.proyectoUsuariosCleanArq.dominio.modelo.UsuarioDto;
import com.example.proyectoUsuariosCleanArq.dominio.useCase.servicio.UsuarioDao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class UsuarioUseCase {

    private final UsuarioDao usuarioDao;

    public UsuarioDto getUsuarioById(Long id){
       return usuarioDao.getUsuarioById(id);
    }
    public List<UsuarioDto> getUsuarios(){
        return usuarioDao.getUsuarios();
    }
    public ResponseEntity<ResponseDto> deleteUsuarioById(Long id){
        return usuarioDao.deleteUsuarioById(id);
    }
    public ResponseEntity<ResponseDto> saveUsuario(UsuarioDto usuario){
        return usuarioDao.saveUsuario(usuario);
    }
}

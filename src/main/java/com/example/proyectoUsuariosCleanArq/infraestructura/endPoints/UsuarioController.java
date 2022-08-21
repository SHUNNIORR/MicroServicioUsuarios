package com.example.proyectoUsuariosCleanArq.infraestructura.endPoints;

import com.example.proyectoUsuariosCleanArq.dominio.modelo.ResponseDto;
import com.example.proyectoUsuariosCleanArq.dominio.modelo.UsuarioDto;
import com.example.proyectoUsuariosCleanArq.dominio.useCase.UsuarioUseCase;
import com.example.proyectoUsuariosCleanArq.dominio.useCase.servicio.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioUseCase usuarioDao;

    @RequestMapping(value = "usuario/{id}")
    public UsuarioDto getUsuario(@PathVariable Long id){
        return usuarioDao.getUsuarioById(id);
    }

    @GetMapping ("usuarios")
    public List<UsuarioDto> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @DeleteMapping("usuario/delete/{id}")
    public ResponseEntity<ResponseDto> deleteUsuario(@PathVariable Long id){
        return usuarioDao.deleteUsuarioById(id);
    }

    @PostMapping("usuario/save")
    public  ResponseEntity<ResponseDto> saveUsuario(@RequestBody UsuarioDto usuario){
        return  usuarioDao.saveUsuario(usuario);
    }


}

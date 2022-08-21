package com.example.proyectoUsuariosCleanArq.infraestructura.persistencia.servicio;

import com.example.proyectoUsuariosCleanArq.dominio.modelo.FileImagenDto;
import com.example.proyectoUsuariosCleanArq.dominio.modelo.ResponseDto;
import com.example.proyectoUsuariosCleanArq.dominio.modelo.UsuarioDto;
import com.example.proyectoUsuariosCleanArq.dominio.useCase.servicio.UsuarioDao;
import com.example.proyectoUsuariosCleanArq.infraestructura.clientFeign.UserImageClientFeign;
import com.example.proyectoUsuariosCleanArq.infraestructura.handlerExceptions.exceptions.NotFoundUserException;
import com.example.proyectoUsuariosCleanArq.infraestructura.handlerExceptions.exceptions.NotUsersInBdException;
import com.example.proyectoUsuariosCleanArq.infraestructura.persistencia.entidad.UsuarioEntidad;
import com.example.proyectoUsuariosCleanArq.infraestructura.persistencia.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioDaoImplements implements UsuarioDao {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UserImageClientFeign userImageClientFeign;

    @Override
    @Transactional
    public ResponseEntity<ResponseDto> saveUsuario(UsuarioDto usuario){
        UsuarioEntidad  usuarioEntidad = UsuarioEntidad.builder()
                .email(usuario.getEmail())
                .apellido(usuario.getApellido())
                .nombre(usuario.getNombre())
                .numeroDocumento(usuario.getNumeroDocumento())
                .telefono(usuario.getTelefono())
                .tipoDocumento(usuario.getTipoDocumento())
                .password(usuario.getPassword())
                .build();
        usuarioRepository.save(usuarioEntidad);
        return new ResponseEntity<ResponseDto>(new ResponseDto("Se ha añadido un nuevo usuario.",usuario),HttpStatus.OK);
    }
    @Override
    @Transactional
    public List<UsuarioDto> getUsuarios() {
        if(usuarioRepository.findAll().isEmpty()){
            throw new NotUsersInBdException();
        }
        List<UsuarioEntidad> usuarioEntidadList = usuarioRepository.findAll();
        List<UsuarioDto> usuarioDtoList = new ArrayList<>();
        for (UsuarioEntidad usuarioEntidad:usuarioEntidadList
             ) {
            UsuarioDto usuarioDto = UsuarioDto.builder()
                    .email(usuarioEntidad.getEmail())
                    .apellido(usuarioEntidad.getApellido())
                    .nombre(usuarioEntidad.getNombre())
                    .numeroDocumento(usuarioEntidad.getNumeroDocumento())
                    .telefono(usuarioEntidad.getTelefono())
                    .tipoDocumento(usuarioEntidad.getTipoDocumento())
                    .password(usuarioEntidad.getPassword())
                    .build();
            usuarioDtoList.add(usuarioDto);
        }
       return usuarioDtoList;
    }

    @Override
    @Transactional
    public UsuarioDto getUsuarioById(Long id) {
        if(usuarioRepository.existsById(id)){

            UsuarioEntidad usuarioEntidad = usuarioRepository.findById(id).get();
            FileImagenDto fileImagenDto = userImageClientFeign.getImageById(usuarioEntidad.getNumeroDocumento());
            UsuarioDto usuarioDto = UsuarioDto.builder()
                    .email(usuarioEntidad.getEmail())
                    .apellido(usuarioEntidad.getApellido())
                    .nombre(usuarioEntidad.getNombre())
                    .numeroDocumento(usuarioEntidad.getNumeroDocumento())
                    .telefono(usuarioEntidad.getTelefono())
                    .tipoDocumento(usuarioEntidad.getTipoDocumento())
                    .password(usuarioEntidad.getPassword())
                    .base64(fileImagenDto.getBase64())
                    .build();
            return usuarioDto;
        }else{
            throw new NotFoundUserException();
        }

    }

    @Override
    @Transactional
    public ResponseEntity<ResponseDto> deleteUsuarioById(Long id) {
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return new ResponseEntity<ResponseDto>(new ResponseDto("Se ha eliminado correctamente el usuario.",null),HttpStatus.OK);
        }else{
            throw new NotFoundUserException();
        }

    }
}

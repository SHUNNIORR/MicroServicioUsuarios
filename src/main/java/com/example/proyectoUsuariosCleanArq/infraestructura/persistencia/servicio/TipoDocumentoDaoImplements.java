package com.example.proyectoUsuariosCleanArq.infraestructura.persistencia.servicio;

import com.example.proyectoUsuariosCleanArq.dominio.modelo.ResponseDto;
import com.example.proyectoUsuariosCleanArq.dominio.modelo.TipoDocumentoDto;
import com.example.proyectoUsuariosCleanArq.dominio.useCase.servicio.TipoDocumentoDao;
import com.example.proyectoUsuariosCleanArq.infraestructura.handlerExceptions.exceptions.NotUsersInBdException;
import com.example.proyectoUsuariosCleanArq.infraestructura.persistencia.entidad.TipoDocumentoEntidad;
import com.example.proyectoUsuariosCleanArq.infraestructura.persistencia.entidad.UsuarioEntidad;
import com.example.proyectoUsuariosCleanArq.infraestructura.persistencia.repositorio.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoDocumentoDaoImplements implements TipoDocumentoDao {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    @Transactional
    public List<TipoDocumentoDto> getAllTipoDocumento(){
        if(tipoDocumentoRepository.findAll().isEmpty()){
            throw new NotUsersInBdException();
        }
        List<TipoDocumentoEntidad> tipoDocumentoEntidadList = tipoDocumentoRepository.findAll();
        List<TipoDocumentoDto> tipoDocumentoDtosList = new ArrayList<>();
        for (TipoDocumentoEntidad tipoDocumentoEntidad:tipoDocumentoEntidadList){
            TipoDocumentoDto tipoDocumentoDto= TipoDocumentoDto.builder()
                    .idTipoDocumento(tipoDocumentoEntidad.getIdTipoDocumento())
                    .descripcionDocumento(tipoDocumentoEntidad.getDescripcionDocumento())
                    .build();
            tipoDocumentoDtosList.add(tipoDocumentoDto);

        }
        return tipoDocumentoDtosList;

    };

    @Override
    @Transactional
    public ResponseEntity<ResponseDto> saveTipoDocumento(TipoDocumentoDto tipoDocumentoDto){
        TipoDocumentoEntidad tipoDocumentoEntidad = TipoDocumentoEntidad.builder()
                .idTipoDocumento(tipoDocumentoDto.getIdTipoDocumento())
                .descripcionDocumento(tipoDocumentoDto.getDescripcionDocumento())
                .build();
        tipoDocumentoRepository.save(tipoDocumentoEntidad);
        return new ResponseEntity<ResponseDto>(new ResponseDto("Se ha añadido un nuevo tipo de documento.",null), HttpStatus.OK);
    };
}

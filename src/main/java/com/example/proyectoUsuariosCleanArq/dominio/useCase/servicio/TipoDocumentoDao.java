package com.example.proyectoUsuariosCleanArq.dominio.useCase.servicio;

import com.example.proyectoUsuariosCleanArq.dominio.modelo.ResponseDto;
import com.example.proyectoUsuariosCleanArq.dominio.modelo.TipoDocumentoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TipoDocumentoDao {
    List<TipoDocumentoDto> getAllTipoDocumento();

    ResponseEntity<ResponseDto> saveTipoDocumento(TipoDocumentoDto tipoDocumentoDto);
}

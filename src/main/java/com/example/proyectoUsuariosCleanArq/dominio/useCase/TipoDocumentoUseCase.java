package com.example.proyectoUsuariosCleanArq.dominio.useCase;

import com.example.proyectoUsuariosCleanArq.dominio.modelo.ResponseDto;
import com.example.proyectoUsuariosCleanArq.dominio.modelo.TipoDocumentoDto;
import com.example.proyectoUsuariosCleanArq.dominio.useCase.servicio.TipoDocumentoDao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class TipoDocumentoUseCase {
    private final TipoDocumentoDao tipoDocumentoDao;

    public List<TipoDocumentoDto> getAllTipoDocumento(){
        return tipoDocumentoDao.getAllTipoDocumento();
    };

    public ResponseEntity<ResponseDto> saveTipoDocumento(TipoDocumentoDto tipoDocumentoDto){
        return tipoDocumentoDao.saveTipoDocumento(tipoDocumentoDto);
    };
}

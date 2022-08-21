package com.example.proyectoUsuariosCleanArq.infraestructura.endPoints;

import com.example.proyectoUsuariosCleanArq.dominio.modelo.ResponseDto;
import com.example.proyectoUsuariosCleanArq.dominio.modelo.TipoDocumentoDto;
import com.example.proyectoUsuariosCleanArq.dominio.modelo.UsuarioDto;
import com.example.proyectoUsuariosCleanArq.dominio.useCase.servicio.TipoDocumentoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TipoDocumentoController {
    @Autowired
    private TipoDocumentoDao tipoDocumentoDao;

    @GetMapping ("documentos")
    public List<TipoDocumentoDto> getUsuarios(){
        return tipoDocumentoDao.getAllTipoDocumento();
    }

    @PostMapping("documentos/save")
    public ResponseEntity<ResponseDto> saveTipoDocumento(@RequestBody TipoDocumentoDto tipoDocumentoDto){
        return  tipoDocumentoDao.saveTipoDocumento(tipoDocumentoDto);
    }
}

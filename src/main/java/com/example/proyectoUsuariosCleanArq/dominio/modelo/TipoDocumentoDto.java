package com.example.proyectoUsuariosCleanArq.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoDocumentoDto {
    private Integer idTipoDocumento;
    private String descripcionDocumento;
}

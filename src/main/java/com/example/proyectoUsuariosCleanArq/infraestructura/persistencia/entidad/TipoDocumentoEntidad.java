package com.example.proyectoUsuariosCleanArq.infraestructura.persistencia.entidad;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_documento")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoDocumentoEntidad {
    @Id
    @Column(name = "idtipo_documento")
    private Integer idTipoDocumento;
    @Column(name = "descripcion_documento")
    private String descripcionDocumento;
}

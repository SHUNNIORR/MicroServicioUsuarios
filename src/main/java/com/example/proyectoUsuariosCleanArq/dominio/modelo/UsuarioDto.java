package com.example.proyectoUsuariosCleanArq.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String password;
    private Integer tipoDocumento;
    private Integer numeroDocumento;
    private String  base64;
}

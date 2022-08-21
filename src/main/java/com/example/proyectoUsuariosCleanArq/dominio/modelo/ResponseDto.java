package com.example.proyectoUsuariosCleanArq.dominio.modelo;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDto {
    private String mensaje;
    private UsuarioDto usuario;
}

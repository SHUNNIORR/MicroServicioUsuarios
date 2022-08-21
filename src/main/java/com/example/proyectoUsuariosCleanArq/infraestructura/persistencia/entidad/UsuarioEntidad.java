package com.example.proyectoUsuariosCleanArq.infraestructura.persistencia.entidad;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "password")
    private String password;
    @Column(name = "idtipo_documento")
    private Integer tipoDocumento;
    @Column(name = "numero_documento")
    private Integer numeroDocumento;
}

package com.example.proyectoUsuariosCleanArq.aplicacion.config;

import com.example.proyectoUsuariosCleanArq.dominio.useCase.TipoDocumentoUseCase;
import com.example.proyectoUsuariosCleanArq.dominio.useCase.UsuarioUseCase;
import com.example.proyectoUsuariosCleanArq.dominio.useCase.servicio.TipoDocumentoDao;
import com.example.proyectoUsuariosCleanArq.dominio.useCase.servicio.UsuarioDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UsuarioUseCase usuarioUseCase(UsuarioDao usuarioDao){
        return  new UsuarioUseCase(usuarioDao);
    }

    @Bean
    public  TipoDocumentoUseCase tipoDocumentoUseCase(TipoDocumentoDao tipoDocumentoDao){
        return  new TipoDocumentoUseCase(tipoDocumentoDao);
    }
}

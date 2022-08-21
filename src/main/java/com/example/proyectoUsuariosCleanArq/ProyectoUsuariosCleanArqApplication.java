package com.example.proyectoUsuariosCleanArq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProyectoUsuariosCleanArqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoUsuariosCleanArqApplication.class, args);
	}

}

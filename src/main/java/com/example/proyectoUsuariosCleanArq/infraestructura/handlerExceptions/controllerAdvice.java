package com.example.proyectoUsuariosCleanArq.infraestructura.handlerExceptions;

import com.example.proyectoUsuariosCleanArq.infraestructura.handlerExceptions.exceptions.NotFoundUserException;
import com.example.proyectoUsuariosCleanArq.infraestructura.handlerExceptions.exceptions.NotUsersInBdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class controllerAdvice {
    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<?> handleNotFoundUser() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", HttpStatus.NOT_FOUND);
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "No se encontró usuario");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NotUsersInBdException.class)
    public ResponseEntity<?> handleNotUsersInBd() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", HttpStatus.NO_CONTENT);
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "No existen usuarios en la base de datos");
        return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);
    }
}

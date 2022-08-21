package com.example.proyectoUsuariosCleanArq.infraestructura.handlerExceptions.exceptions;

public class NotFoundUserException extends RuntimeException{
    public  NotFoundUserException(){
        super("No se encontró usuario.");
    }
}

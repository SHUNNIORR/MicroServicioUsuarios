package com.example.proyectoUsuariosCleanArq.infraestructura.handlerExceptions.exceptions;

public class NotUsersInBdException extends RuntimeException{
    public NotUsersInBdException(){
        super("No existen registros de usuarios.");
    }
}

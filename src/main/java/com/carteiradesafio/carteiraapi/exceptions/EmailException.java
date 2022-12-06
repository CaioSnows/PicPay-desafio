package com.carteiradesafio.carteiraapi.exceptions;

public class EmailException extends RuntimeException{

    public EmailException(){
        super("Email inválido ou já cadastrado");
    }
}

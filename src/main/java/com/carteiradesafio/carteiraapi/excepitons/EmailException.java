package com.carteiradesafio.carteiraapi.excepitons;

public class EmailException extends RuntimeException{

    public EmailException(){
        super("Email inválido ou já cadastrado");
    }
}

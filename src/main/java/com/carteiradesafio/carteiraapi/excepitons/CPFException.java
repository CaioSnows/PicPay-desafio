package com.carteiradesafio.carteiraapi.excepitons;

public class CPFException extends RuntimeException{

    public CPFException() {
        super("CFP inválido");
    }
}

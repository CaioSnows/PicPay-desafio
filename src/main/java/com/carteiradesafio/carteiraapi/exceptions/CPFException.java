package com.carteiradesafio.carteiraapi.exceptions;

public class CPFException extends RuntimeException{

    public CPFException() {
        super("CFP/CNPJ inválido ou já cadastrado");
    }
}

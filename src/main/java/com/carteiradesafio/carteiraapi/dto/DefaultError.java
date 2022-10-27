package com.carteiradesafio.carteiraapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultError {

    private int erro;
    private String message;
}

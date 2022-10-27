package com.carteiradesafio.carteiraapi.excepitons;

import com.carteiradesafio.carteiraapi.dto.DefaultError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApplicationExceptHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleExcepition(Exception e){
        log.info("Caiu no handler");

        DefaultError erro = new DefaultError(HttpStatus.NOT_FOUND.value(), "Não existe o usuario");

        return new ResponseEntity(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity CpfException(Exception e){
        log.info("CPF INVÁLIDO");

        DefaultError erro = new DefaultError(HttpStatus.UNAUTHORIZED.value(), "CPF inválido");

        return new ResponseEntity(erro, HttpStatus.UNAUTHORIZED);
    }
}

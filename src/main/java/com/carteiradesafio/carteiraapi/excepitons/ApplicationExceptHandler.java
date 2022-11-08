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
    public ResponseEntity<DefaultError> handleExcepition(Exception e) {
        log.info("Caiu no handler");
        log.info(e.getMessage());

        DefaultError erro = new DefaultError(HttpStatus.NOT_FOUND.value(), e.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CPFException.class)
    public ResponseEntity<DefaultError> CpfException(Exception e) {
        log.info("CPF INVÁLIDO");

        DefaultError erro = new DefaultError(HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<DefaultError> EmailException(Exception e) {
        log.info("EMAIL INVÁLIDO");

        DefaultError erro = new DefaultError(HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
}

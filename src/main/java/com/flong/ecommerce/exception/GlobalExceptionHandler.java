package com.flong.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ProblemDetail handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Entidade não encontrada");
        problemDetail.setProperty("Data", java.time.ZonedDateTime.now());
        problemDetail.setProperty("path", request.getDescription(false).replace("uri=", ""));
        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGenericaException(Exception ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno do servidor.");
        problemDetail.setTitle("Erro Interno");
        problemDetail.setProperty("timestamp", java.time.ZonedDateTime.now());
        problemDetail.setProperty("path", request.getDescription(false).replace("uri=", ""));
        return problemDetail;
    }

    @ExceptionHandler(EntidadeExistenteException.class)
    public ProblemDetail handleEntidadeExistenteException(EntidadeExistenteException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Usuário já cadastrado");
        problemDetail.setTitle("Entidade existente");
        problemDetail.setProperty("Data", java.time.ZonedDateTime.now());
        return problemDetail;
    }
}

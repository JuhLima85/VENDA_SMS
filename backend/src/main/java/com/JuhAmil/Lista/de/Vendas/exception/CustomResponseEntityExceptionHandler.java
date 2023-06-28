package com.JuhAmil.Lista.de.Vendas.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ VendaException.class, SmsException.class })
    protected ResponseEntity<Object> handleCustomExceptions(Exception ex, WebRequest request) {
       
        String errorMessage = ex.getMessage();
       
        ApiResponse apiResponse = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage);
       
        return new ResponseEntity<>(apiResponse, new HttpHeaders(), apiResponse.getStatus());
    }
}

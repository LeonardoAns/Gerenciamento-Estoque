package com.estudoDeCaso.shopp.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionMessage> notFoundException(NotFoundException notFoundException, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionMessage(request, HttpStatus.NOT_FOUND, notFoundException.getMessage()));
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ExceptionMessage> notFoundException(AlreadyExistsException alreadyExistsException, HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionMessage(request,HttpStatus.CONFLICT, alreadyExistsException.getMessage()));
    }


    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ExceptionMessage> notFoundException(InvalidRequestException invalidRequestException, HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionMessage(request,HttpStatus.BAD_REQUEST, invalidRequestException.getMessage()));
    }
}

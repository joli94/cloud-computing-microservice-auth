package ro.unibuc.fmi.dietapp.microservice.authentication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ro.unibuc.fmi.dietapp.microservice.authentication.dto.ErrorDto;
import ro.unibuc.fmi.dietapp.microservice.authentication.exception.JwtTokenMalformedException;
import ro.unibuc.fmi.dietapp.microservice.authentication.exception.JwtTokenMissingException;


@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler
    protected ResponseEntity<ErrorDto> handleJwtTokenMalformedException(JwtTokenMalformedException ex){
        return new ResponseEntity<>(
                ErrorDto.builder().code(400).message(ex.getMessage()).build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorDto> handleJwtTokenMissingException(JwtTokenMissingException ex){
        return new ResponseEntity<>(
                ErrorDto.builder().code(400).message(ex.getMessage()).build(), HttpStatus.BAD_REQUEST
        );
    }
}

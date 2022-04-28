package nl.camiel.novi.backend.TechItEasy.controller;

import nl.camiel.novi.backend.TechItEasy.Exception.IdNotExistException;
import nl.camiel.novi.backend.TechItEasy.Exception.PriceInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IdNotExistException.class)


    public ResponseEntity<Object> exception(IdNotExistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PriceInvalidException.class)
    public ResponseEntity<Object> exception(PriceInvalidException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}

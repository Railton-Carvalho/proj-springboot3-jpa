package com.webspring.course.resources.exceptions;

import com.webspring.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serializable;
import java.time.Instant;

@ControllerAdvice //intercepta as excecao para que o obj possa executar algum tipo de tratamento
public class ResourceExceptionHandler implements Serializable {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> searchNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}

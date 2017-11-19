package com.bbs.restapi.controller;

import com.bbs.restapi.exception.TechnologyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by aboutin on 9/30/17.
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(TechnologyNotFoundException.class)
    public ResponseEntity handleTechnologyNotFoundException(TechnologyNotFoundException e) {
        // TODO: Change to JSON payload with statusCode, errorCode, and error are returned
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}

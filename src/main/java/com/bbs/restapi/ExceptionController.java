package com.bbs.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by aboutin on 9/30/17.
 */
@ControllerAdvice
public class ExceptionController {
    // TODO: Handle wrong operations on endpoints

    @ExceptionHandler(TechnologyNotFoundException.class)
    public ResponseEntity handleTechnologyNotFoundException(TechnologyNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}

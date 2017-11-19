package com.bbs.restapi.exception;

/**
 * Created by aboutin on 9/30/17.
 */
public class TechnologyNotFoundException extends RuntimeException {
    private static final String ERROR = "Technology not found id: ";
    private static final String ERROR_KEY = "technology.notFound";

    // TODO: Either update exception controller or use class annotations on exceptions
    // TODO: Create super class with statusCode, errorCode, and error
    private TechnologyNotFoundException() {
        //
    }

    public TechnologyNotFoundException(final int id) {
        super(ERROR + id);
    }
}

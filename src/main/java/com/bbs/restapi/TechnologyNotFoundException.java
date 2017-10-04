package com.bbs.restapi;

/**
 * Created by aboutin on 9/30/17.
 */
public class TechnologyNotFoundException extends RuntimeException {
    private static final String error = "Technology not found id: ";

    private TechnologyNotFoundException() {
        //
    }

    public TechnologyNotFoundException(final int id) {
        super(error + id);
    }
}

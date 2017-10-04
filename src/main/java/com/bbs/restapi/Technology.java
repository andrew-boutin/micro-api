package com.bbs.restapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aboutin on 9/30/17.
 */
public class Technology {
    // TODO: Validation annotations...
    private final int id;

    // TODO: Make final
    private String title;

    private String link;

    // TODO: Look up JsonCreator
    // TODO: Look up JsonProperty
    // TODO: Ignore id on create...
    @JsonCreator
    public Technology(@JsonProperty("id") final int id,
                      @JsonProperty("title") final String title,
                      @JsonProperty("link") final String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }

    int getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    String getLink() {
        return link;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setLink(String link) {
        this.link = link;
    }

    // TODO: toString
}

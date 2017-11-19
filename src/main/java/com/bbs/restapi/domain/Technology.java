package com.bbs.restapi.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by aboutin on 9/30/17.
 */
public class Technology {
    // TODO: Make fields final
    // TODO: Don't expose actual DB id
    // Adding @JsonProperty allows serialization to work
    @JsonProperty("id")
    private final int id;

    @NotBlank
    @JsonProperty("title")
    private String title;

    @NotBlank
    @JsonProperty("link")
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

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
//
//    void setTitle(String title) {
//        this.title = title;
//    }
//
//    void setLink(String link) {
//        this.link = link;
//    }

    // TODO: toString, equals, hashCode
}

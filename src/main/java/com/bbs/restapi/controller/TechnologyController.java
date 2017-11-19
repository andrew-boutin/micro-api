package com.bbs.restapi.controller;

import com.bbs.restapi.domain.Technology;
import com.bbs.restapi.service.TechnologyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by aboutin on 9/29/17.
 */
// @RestController implies @Controller and @ResponseBody - don't need to put @ResponseBody on every controller method.
// TODO: What does @AutoWire actually do?
// TODO: Look up what @RequestParam actually does
// TODO: @Controller?
// TODO: 204 No Content or 200 Success when no response body?
@RestController
public class TechnologyController {
    private static final String ALL_TECH_URL = "tech";
    private static final String SINGLE_TECH_URL = ALL_TECH_URL + "/{id}";

    private static final Logger logger = LoggerFactory.getLogger(TechnologyController.class);

    private final TechnologyService technologyService;

    @Autowired
    public TechnologyController(final TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping(value = ALL_TECH_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Technology> getTechnologies() {
        logger.debug("getTechnologies");
        return technologyService.getTechnologies();
    }

    @GetMapping(value = SINGLE_TECH_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public Technology getTechnology(@PathVariable("id") final int id) {
        logger.debug("getTechnology {}", id);
        return technologyService.getTechnology(id);
    }

    @PostMapping(value = ALL_TECH_URL, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTechnology(@RequestBody @Valid final Technology technology) {
        logger.debug("createTechnology {}", technology);
        technologyService.createTechnology(technology);
    }

    @PutMapping(value = SINGLE_TECH_URL, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTechnology(@PathVariable("id") final int id, @RequestBody @Valid final Technology technology) {
        logger.debug("updateTechnology {} {}", id, technology);
        technologyService.updateTechnology(id, technology);
    }

    @DeleteMapping(SINGLE_TECH_URL)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTechnology(@PathVariable("id") final int id) {
        logger.debug("deleteTechnology {}", id);
        technologyService.deleteTechnology(id);
    }
}

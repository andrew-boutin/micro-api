package com.bbs.restapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by aboutin on 9/29/17.
 */
// TODO: What exactly does RestController do automagically?
// TODO: Add linking
// TODO: Add swagger documentation
// TODO: What does @AutoWire actually do?
// TODO: Look up what @RequestParam actually does
// TODO: Look into HAL format
@RestController
public class Controller {
    private static final String ALL_TECH_URL = "tech";
    private static final String SINGLE_TECH_URL = ALL_TECH_URL + "/{id}";

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    private final TechnologyService technologyService;

    @Autowired
    public Controller(final TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping
    public String hello(@RequestParam(defaultValue = "World") String name) {
        return "Hello " + name;
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
    public void createTechnology(@RequestBody final Technology technology) {
        logger.debug("createTechnology {}", technology);
        technologyService.createTechnology(technology);
    }

    @PutMapping(value = SINGLE_TECH_URL, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTechnology(@PathVariable("id") final int id, @RequestBody final Technology technology) {
        logger.debug("updateTechnology {} {}", id, technology);
        technologyService.updateTechnology(id, technology);
    }

    @DeleteMapping(SINGLE_TECH_URL)
    public void deleteTechnology(@PathVariable("id") final int id) {
        logger.debug("deleteTechnology {}", id);
        technologyService.deleteTechnology(id);
    }
}

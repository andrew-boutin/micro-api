package com.bbs.restapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aboutin on 9/30/17.
 */
@Service
public class TechnologyService {
    private static final Logger logger = LoggerFactory.getLogger(TechnologyService.class);

    private final TechnologyDao technologyDao;

    @Autowired
    public TechnologyService(final TechnologyDao technologyDao) {
        this.technologyDao = technologyDao;
    }

    // TODO: Alphabetical
    List<Technology> getTechnologies() {
        return technologyDao.getAllTechnologies();
    }

    Technology getTechnology(final int id) {
        return technologyDao.getTechnology(id);
    }

    void createTechnology(final Technology technology) {
        technologyDao.createTechnology(technology);
    }

    void updateTechnology(final int id, final Technology technology) throws TechnologyNotFoundException {
        technologyDao.updateTechnology(id, technology);
    }

    void deleteTechnology(final int id) throws TechnologyNotFoundException {
        technologyDao.deleteTechnology(id);
    }
}

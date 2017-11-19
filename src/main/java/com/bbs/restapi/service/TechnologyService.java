package com.bbs.restapi.service;

import com.bbs.restapi.domain.Technology;
import com.bbs.restapi.persistence.TechnologyDao;
import com.bbs.restapi.exception.TechnologyNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aboutin on 9/30/17.
 */
// TODO: Use interface
@Service
public class TechnologyService {
    private static final Logger logger = LoggerFactory.getLogger(TechnologyService.class);

    private final TechnologyDao technologyDao;

    @Autowired
    public TechnologyService(final TechnologyDao technologyDao) {
        this.technologyDao = technologyDao;
    }

    public List<Technology> getTechnologies() {
        return technologyDao.getAllTechnologies();
    }

    public Technology getTechnology(final int id) {
        return technologyDao.getTechnology(id);
    }

    public void createTechnology(final Technology technology) {
        technologyDao.createTechnology(technology);
    }

    public void updateTechnology(final int id, final Technology technology) throws TechnologyNotFoundException {
        technologyDao.updateTechnology(id, technology);
    }

    public void deleteTechnology(final int id) throws TechnologyNotFoundException {
        technologyDao.deleteTechnology(id);
    }
}

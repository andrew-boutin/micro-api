package com.bbs.restapi.persistence;

import com.bbs.restapi.domain.Technology;
import com.bbs.restapi.exception.TechnologyNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by aboutin on 9/30/17.
 */
// TODO: Use interface
@Repository
public class TechnologyDao {
    private static final Logger logger = LoggerFactory.getLogger(TechnologyDao.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public TechnologyDao(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final String GET_SINGLE_TECHNOLOGY_QUERY = "SELECT * FROM technology WHERE ID = :id";

    public Technology getTechnology(final int id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        List<Technology> results = namedParameterJdbcTemplate.query(GET_SINGLE_TECHNOLOGY_QUERY, namedParameters, technologyRowMapper);

        if(results.isEmpty()) {
            throw new TechnologyNotFoundException(id);
        }
        else if(results.size() > 1) {
            logger.error("getTechnology returned more than 1 result - {}", id);
        }

        return results.get(0);
    }

    private static final String GET_ALL_TECHNOLOGIES_QUERY = "SELECT * FROM technology;";

    public List<Technology> getAllTechnologies() {
        return namedParameterJdbcTemplate.query(GET_ALL_TECHNOLOGIES_QUERY, technologyRowMapper);
    }

    private static final String CREATE_TECHNOLOGY_QUERY = "INSERT INTO technology (id, title, link) VALUES (:id, :title, :link)";

    public void createTechnology(final Technology technology) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", technology.getId());
        namedParameters.addValue("title", technology.getTitle());
        namedParameters.addValue("link", technology.getLink());
        int numRows = namedParameterJdbcTemplate.update(CREATE_TECHNOLOGY_QUERY, namedParameters);

        if(numRows != 1) {
            logger.error("createTechnology rows affected {} - {}", numRows, technology);
        }
    }

    private static final String DELETE_TECHNOLOGY_QUERY = "DELETE FROM technology WHERE id = :id";

    public void deleteTechnology(final int id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        int numRows = namedParameterJdbcTemplate.update(DELETE_TECHNOLOGY_QUERY, namedParameters);

        if(numRows != 1) {
            logger.error("deleteTechnology rows affected {} - {}", numRows, id);
        }
    }

    private static final String UPDATE_TECHNOLOGY_QUERY = "UPDATE technology SET title = :title, link = :link WHERE id = :id";

    public void updateTechnology(final int id, final Technology technology) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        namedParameters.addValue("title", technology.getTitle());
        namedParameters.addValue("link", technology.getLink());
        int numRows = namedParameterJdbcTemplate.update(UPDATE_TECHNOLOGY_QUERY, namedParameters);

        if(numRows != 1) {
            logger.error("updateTechnology rows affected {} - {} {}", numRows, id, technology);
        }
    }

    private static final RowMapper<Technology> technologyRowMapper = new RowMapper<Technology>(){
        @Override
        public Technology mapRow(ResultSet rs, int rowNumber) throws SQLException {
            return new Technology(rs.getInt("id"),
                                  rs.getString("title"),
                                  rs.getString("link"));
        }
    };
}

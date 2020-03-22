package net.javacrumbs.datasourcedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TestRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(TestRepository.class);

    public TestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insert() {
        try {
            jdbcTemplate.update("insert into my_table values('test')");
        } catch(DataAccessException e) {
            // ignored, expected behavior
            logger.info("action=error_on_insert {}", e.getMessage());
        }
    }
}

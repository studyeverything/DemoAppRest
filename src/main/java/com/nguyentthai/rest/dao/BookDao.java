package com.nguyentthai.rest.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BookDao {
    private static final Logger log = LoggerFactory.getLogger(BookDao.class);

    @Autowired
    private JdbcTemplate template;
}

package io.github.alderan_smile.JavaTest.repository.impl;

import function_fun.SuitJdbcSpring.Impl.FunJdbcSpringSaveImpl;
import io.github.alderan_smile.JavaTest.repository.MavenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202468.0.38                                                                                     *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
@Repository
public class MavenRepositoryImpl extends FunJdbcSpringSaveImpl implements MavenRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MavenRepositoryImpl(@Qualifier("dataSource")DataSource dataSource) {
        super(new JdbcTemplate(dataSource));
    }

    @Override
    public Integer testConnection() {
        try {
            return jdbcTemplate.queryForObject("SELECT 1 FROM DUAL", Integer.class);
        } catch (Exception e) {
            Integer error = 0;
            return error;
        }
    }
}

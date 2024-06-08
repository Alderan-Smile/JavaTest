package io.github.alderan_smile.JavaTest.dbconfig;

import org.apache.logging.log4j.core.config.AbstractConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202468.0.22                                                                                     *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
@Configuration
@EnableJdbcRepositories(jdbcOperationsRef = "jdbcOperations",
        transactionManagerRef = "transactionManager",
        basePackages = "io.github.alderan_smile.JavaTest.repository")
public class TransactionJdbcConfig extends AbstractJdbcConfiguration {

    @Primary
    @Bean(name = "jdbcOperations")
    public NamedParameterJdbcOperations jdbcOperations(@Qualifier("dataSource")DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource")DataSource dataSource) {
        return new JdbcTransactionManager(dataSource);
    }
}

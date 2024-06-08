package io.github.alderan_smile.JavaTest.dbconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202468.0.9                                                                                      *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
@Slf4j
@Configuration
@EnableTransactionManagement
public class DataBaseConfig {

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/javatests");
        dataSourceBuilder.username("base");
        dataSourceBuilder.password("base");
        return dataSourceBuilder.build();
    }
}

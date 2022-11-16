package cl.smile.javatest.connection;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import org.springframework.boot.jdbc.DataSourceBuilder;

/**
 * @author Oliver Consterla Araya
 * @version 0.1
 * @since 2022
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "oracleEntityManagerFactory",
        transactionManagerRef = "oracleTransactionManager",
        basePackages = "cl.smile.javatest.repository")
@EnableTransactionManagement
public class DataBaseConfig {

    @Autowired
    public Environment env;

    private Map<String, String> jpaProps = new HashMap<String, String>();
    {
        jpaProps.put("hibernate.hbm2ddl.auto", "none");
        jpaProps.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");

    }

    @Primary
    @Bean(name = "oracleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(final EntityManagerFactoryBuilder builder,
                                                                       final @Qualifier("oracle-db") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("cl.smile.javatest.model")
                .persistenceUnit("fistDb")
                .properties(jpaProps).build();
    }

    @Primary
	@Bean(name = "oracle-db")
	public DataSource dataSourceOracle() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("oracle.jdbc.OracleDriver");
		dataSourceBuilder.url("jdbc:oracle:thin:@localhost:1521:XE");
		dataSourceBuilder.username("ALDERAN");
		dataSourceBuilder.password("SMILE");
		return dataSourceBuilder.build();
	}

    @Bean(name = "oracleTransactionManager")
    public PlatformTransactionManager TransactionManager(
            @Qualifier("oracleEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

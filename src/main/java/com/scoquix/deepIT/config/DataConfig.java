package com.scoquix.deepIT.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.scoquix.deepIT.repository")
@PropertySource("classpath:database.properties")
public class DataConfig {
    private final String PROPERTY_URL = "url";
    private final String PROPERTY_USERNAME = "db_user";
    private final String PROPERTY_PASSWORD = "db_password";
    private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
    private final String PROPERTY_DIALECT = "hibernate.dialect";

    @Autowired
    Environment environment;

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
        lfb.setDataSource(dataSource());
        lfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        lfb.setPackagesToScan("com.scoquix.deepIT.entity");
        lfb.setJpaProperties(hibernateProps());
        return lfb;
    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        System.out.println("URL: "+environment.getProperty(PROPERTY_URL));
        System.out.println("USERNAME: "+environment.getProperty(PROPERTY_USERNAME));
        System.out.println("PASSWORD: "+environment.getProperty(PROPERTY_PASSWORD));
        System.out.println("DRIVER: "+environment.getProperty("driver"));
        ds.setUrl(environment.getProperty(PROPERTY_URL));
        ds.setUsername(environment.getProperty(PROPERTY_USERNAME));
        ds.setPassword(environment.getProperty(PROPERTY_PASSWORD));
        String PROPERTY_DRIVER = "driver";
        ds.setDriverClassName(Objects.requireNonNull(environment.getProperty(PROPERTY_DRIVER)));
        return ds;
    }

    Properties hibernateProps(){
        Properties props = new Properties();
        props.setProperty(PROPERTY_DIALECT,environment.getProperty(PROPERTY_DIALECT));
        props.setProperty(PROPERTY_SHOW_SQL,environment.getProperty(PROPERTY_SHOW_SQL));
        return props;

    }

    @Bean
    JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}

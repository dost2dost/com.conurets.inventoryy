package com.conurets.inventory.configuration.database;

import com.conurets.inventory.util.InventoryConstants;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * @author MSA
 */

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.conurets.inventory.*"})
public class DatabaseConfiguration {
    protected static Logger logger = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{InventoryConstants.ENTITY_PACKAGE});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(InventoryConstants.HIBERNATE_DIALECT, environment.getRequiredProperty(InventoryConstants.HIBERNATE_DIALECT));
        properties.put(InventoryConstants.HIBERNATE_SHOW_SQL, environment.getRequiredProperty(InventoryConstants.HIBERNATE_SHOW_SQL));
        properties.put(InventoryConstants.HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(InventoryConstants.HIBERNATE_FORMAT_SQL));
        properties.put(InventoryConstants.HIBERNATE_GLOBAL_QUOTED_IDENTIFIERS, environment.getRequiredProperty(InventoryConstants.HIBERNATE_GLOBAL_QUOTED_IDENTIFIERS));
        properties.put(InventoryConstants.HIBERNATE_DDL_AUTO, environment.getRequiredProperty(InventoryConstants.HIBERNATE_DDL_AUTO));
        return properties;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty(InventoryConstants.JDBC_DRIVER_CLASS_NAME));
        dataSource.setUrl(environment.getRequiredProperty(InventoryConstants.JDBC_URL));
        dataSource.setUsername(environment.getRequiredProperty(InventoryConstants.JDBC_USER_NAME));
        dataSource.setPassword(environment.getRequiredProperty(InventoryConstants.JDBC_PASSWORD));
        dataSource.setMinIdle(environment.getRequiredProperty(InventoryConstants.JDBC_MIN_IDLE, Integer.class));
        dataSource.setMaxIdle(environment.getRequiredProperty(InventoryConstants.JDBC_MAX_IDLE, Integer.class));
        dataSource.setInitialSize(environment.getRequiredProperty(InventoryConstants.JDBC_INITIAL_SIZE, Integer.class));
        dataSource.setValidationQuery(environment.getRequiredProperty(InventoryConstants.JDBC_VALIDATION_QUERY));
        dataSource.setDefaultAutoCommit(Boolean.FALSE);
        return dataSource;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
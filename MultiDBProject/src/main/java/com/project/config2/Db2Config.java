package com.project.config2;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "db2EntityManager"
        ,transactionManagerRef = "db2TransactionManager"
        , basePackages = "com.project.repo.pd")
public class Db2Config {


    @Bean
    @ConfigurationProperties(prefix = "db2.datasource")
    @Primary
    public DataSource db2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean db2EntityManager(EntityManagerFactoryBuilder emfb) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl-auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show-sql", "true");
        properties.put("hibernate.format_sql", "true");


        return emfb.dataSource(db2DataSource())
                .packages("com.project.model.product")
                .properties(properties)
                .persistenceUnit("teluskodb")
                .build();
    }

    //Transaction
    @Bean
    @Primary
    public PlatformTransactionManager db2TransactionManager(@Qualifier("db2EntityManager") EntityManagerFactory factory){
        return new JpaTransactionManager(factory);
    }
}


package ru.cucumber_template.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@Profile("jdbc")
public class DBBeanConfig {
    @Autowired
    PropertiesConfig config;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(config.getDataBase().getDriver());
        dataSource.setUrl(config.getDataBase().getUrl());
        dataSource.setUsername(config.getDataBase().getName());
        dataSource.setPassword(config.getDataBase().getPassword());

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}

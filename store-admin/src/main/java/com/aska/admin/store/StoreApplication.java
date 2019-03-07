package com.aska.admin.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

//@Configuration
//@EnableAutoConfiguration
//@EnableWebMvc
//@ComponentScan
@SpringBootApplication
public class StoreApplication {


	@Autowired
	private Environment environmentProperties;

	private static final String PRIMARY_DATA_SOURCE_URL = "spring.datasource.url";
	private static final String PRIMARY_DATA_SOURCE_USERNAME = "spring.datasource.username";
	private static final String PRIMARY_DATA_SOURCE_PASSWORD = "spring.datasource.passsword";
    private static final String PRIMARY_DATA_SOURCE_DRIVER = "spring.datasource.driver.class";


	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	@Bean
	@Primary
	public DataSource primaryDataSource(){
		return DataSourceBuilder
				.create()
                .driverClassName(environmentProperties.getProperty(PRIMARY_DATA_SOURCE_DRIVER))
				.url(environmentProperties.getProperty(PRIMARY_DATA_SOURCE_URL))
				.username(environmentProperties.getProperty(PRIMARY_DATA_SOURCE_USERNAME))
				.password(environmentProperties.getProperty(PRIMARY_DATA_SOURCE_PASSWORD))
				.build();
	}

}

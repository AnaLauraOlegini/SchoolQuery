package com.totvs.sl.school.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.totvs.tjf.api.jpa.repository.impl.ApiJpaRepositoryImpl;

@SpringBootApplication
@EnableConfigurationProperties({SchoolProperties.class, FlyWayProperties.class })
@EnableJpaRepositories(repositoryBaseClass = ApiJpaRepositoryImpl.class)	
public class SchoolQueryApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolQueryApplication.class, args);
	}
}

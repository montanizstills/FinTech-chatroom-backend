package com.github.nez.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class BeanRegisterer {

    @Bean(name = "myentitymanager")
    public EntityManager getEntityManager(@Autowired EntityManager manager) {
        return manager;
    }
}

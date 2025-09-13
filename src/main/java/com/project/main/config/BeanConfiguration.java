package com.project.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BeanConfiguration {

    @Bean
    public PlatformTransactionManager getPlatformTransactionManager(MongoDatabaseFactory factory) {
        return new MongoTransactionManager(factory);
    }

}

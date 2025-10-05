package com.project.main.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
@EnableAutoConfiguration
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    void testSendMain(){
        redisTemplate.opsForValue().set("email","nikhil77@gmail.com");
        Object email=redisTemplate.opsForValue().get("email");


    }




}

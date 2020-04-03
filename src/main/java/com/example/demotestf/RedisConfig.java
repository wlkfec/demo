package com.example.demotestf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.PostConstruct;

/**
 * @author unisound
 * Redis 配置类
 */

@Configuration
public class RedisConfig {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void init() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
    }

    @Bean
    public ValueOperations valueOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForValue();
    }

    @Bean
    public HashOperations hashOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForHash();
    }
}
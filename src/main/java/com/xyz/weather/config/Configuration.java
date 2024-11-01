package com.xyz.weather.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Encoder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@org.springframework.context.annotation.Configuration
@EnableFeignClients (basePackages = "com.xyz.weather.proxy")
public class Configuration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        return emf;
    }
    @Bean
    public EntityManager entityManager() {
        EntityManagerFactory emf = entityManagerFactory();
        EntityManager em = emf.createEntityManager();
        return em;
    }

//    @Bean
//    public Encoder feignEncoder() {
//
//        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
//
//        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
//
//        return new SpringEncoder(objectFactory);
//
//    }
}

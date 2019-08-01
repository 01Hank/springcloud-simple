package com.zxb.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class consumer {
    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }


    public static void main(String[] args){
        SpringApplication.run(consumer.class,args);
    }
}

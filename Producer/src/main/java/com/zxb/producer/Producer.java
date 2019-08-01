package com.zxb.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.zxb.producer.Mapper")
//@EnableDiscoveryClient
@EnableEurekaClient
@RestController
public class Producer {
    public static void main(String[] args) {
        SpringApplication.run(Producer.class,args);

    }
}

package com.zxb.druid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ServletComponentScan
//@EnableDiscoveryClient
@EnableEurekaClient
@RestController
@EnableAsync//异步任务
@EnableScheduling//定时任务
public class druid {
    public static  void main(String[] args){
        SpringApplication.run(druid.class,args);
    }
}

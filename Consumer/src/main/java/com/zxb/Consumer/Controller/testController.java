package com.zxb.Consumer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    private RestTemplate restTemplate;

    @CrossOrigin("*")
    @GetMapping("/getTest")
    public  String  sayHello(){
        return restTemplate.getForObject("http://localhost:8091/test/hello",String.class);
    }
}

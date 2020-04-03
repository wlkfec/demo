package com.example.demotestf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;

@EnableCaching
@RestController
@SpringBootApplication
public class DemoTestfApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTestfApplication.class, args);
    }

    @Autowired
    private DemoIntf demoIntf;

    @GetMapping("test")
    public Object test() {
        System.out.println(demoIntf.getInfo());
        return Arrays.asList("xx","cc");
    }

}

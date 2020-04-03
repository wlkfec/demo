package com.example.demotestf;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoIntfImpl implements DemoIntf {



    @Cacheable(value = "content")
    @Override
    public String getInfo() {
        System.out.println("xxxxxxxx");
        return "ok";
    }
}

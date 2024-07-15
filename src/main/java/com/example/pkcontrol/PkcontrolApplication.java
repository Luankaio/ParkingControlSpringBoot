package com.example.pkcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PkcontrolApplication {

    public static void main(String[] args) {
        SpringApplication.run(PkcontrolApplication.class, args);
    }

    @GetMapping("/")
    public String index(){
        return "Hello World";
    }
}

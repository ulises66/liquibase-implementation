package com.healthcare.core.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by wichon on 2/13/17.
 */
@SpringBootApplication(scanBasePackages = "com.healthcare")
//@EnableCaching
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

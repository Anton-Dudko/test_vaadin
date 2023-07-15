package com.example.test;

import com.vaadin.flow.component.UI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication extends UI {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}

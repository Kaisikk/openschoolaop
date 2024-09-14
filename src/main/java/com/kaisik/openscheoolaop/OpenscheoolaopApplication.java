package com.kaisik.openscheoolaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableAspectJAutoProxy
public class OpenscheoolaopApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenscheoolaopApplication.class, args);
    }

}

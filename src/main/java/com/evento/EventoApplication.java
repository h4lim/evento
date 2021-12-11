package com.evento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EventoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventoApplication.class, args);
    }

}


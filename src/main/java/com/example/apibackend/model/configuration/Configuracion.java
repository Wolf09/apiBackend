package com.example.apibackend.model.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.example.apijar.model.services.HeroeServiceImpl;

@Configuration
public class Configuracion {

    @Bean
    public HeroeServiceImpl serv(){
        return new HeroeServiceImpl();
    }

}

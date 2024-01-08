package com.example.apibackend;


import com.example.apibackend.model.auth.GeneradorJwt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiJarApplication {

    public static void main(String[] args){
        GeneradorJwt.generarToken();
        SpringApplication.run(ApiJarApplication.class, args);

    }


}

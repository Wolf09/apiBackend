package com.example.apibackend.model.auth;

import io.jsonwebtoken.Jwts;

import java.util.Date;

import static com.example.apibackend.model.auth.TokenJwtConfig.*;
public class GeneradorJwt {


    public static void generarToken(){

        String token= Jwts.builder()
                .subject(USER_NAME)
                .expiration(new Date(System.currentTimeMillis()+ 7200000))
                .issuedAt(new Date())
                .signWith(SECRET_KEY)
                .compact();
        System.out.println("========TOKEN: "+token +" ================");

    }
}

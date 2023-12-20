package com.example.apibackend.controller;

import com.example.apibackend.model.services.HeroeServiceImplement;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.example.apijar.model.dto.Heroe;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class HeroeController {
    @Autowired
    private HeroeServiceImplement heroeService;

    @GetMapping("/heroes")
    public ResponseEntity<List<Heroe>> getAll() throws JsonProcessingException {
        ResponseEntity<List<Heroe>> resp = null;
        try{
            resp= new ResponseEntity<>(heroeService.getHeroes(), HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return resp;
    }
    @GetMapping("/heroe/{id}")
    public ResponseEntity<Heroe> getHeroe(@PathVariable("id") Integer id) throws JsonProcessingException {
        ResponseEntity<Heroe> resp = null;
        try {
            resp =new ResponseEntity<> (heroeService.getHeroe(id), HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return resp;
    }

}

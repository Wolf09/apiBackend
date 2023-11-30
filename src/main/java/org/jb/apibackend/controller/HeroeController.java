package org.jb.apibackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jb.apibackend.model.dto.Heroe;
import org.jb.apibackend.model.services.HeroeServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroeController {
    @Autowired
    private HeroeServiceImplement heroeService;

    @GetMapping("/heroes")
    public ResponseEntity<List<Heroe>> getAll() throws JsonProcessingException {
        return new ResponseEntity<>(heroeService.getHeroes(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Heroe> getHeroe(@PathVariable("id") Integer id) throws JsonProcessingException {
            return new ResponseEntity<>(heroeService.getHeroe(id), HttpStatus.OK);
    }
}

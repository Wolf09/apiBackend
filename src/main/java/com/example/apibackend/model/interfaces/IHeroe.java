package com.example.apibackend.model.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.apijar.model.dto.Heroe;
import java.util.List;

public interface IHeroe {
    List<Heroe> getHeroes() throws JsonProcessingException;
    Heroe getHeroe(int id) throws JsonProcessingException;
}

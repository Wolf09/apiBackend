package com.example.apibackend.model.services;

import com.example.apibackend.model.exception.ResourceNotFoundException;
import com.example.apibackend.model.interfaces.IHeroe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.apijar.model.dto.Heroe;
import org.example.apijar.model.services.HeroeServiceImpl;

import java.util.List;
@Service
public class HeroeServiceImplement implements IHeroe {
    @Autowired
    private HeroeServiceImpl heroes;

    public HeroeServiceImplement() {
    }

    @Override
    public List<Heroe> getHeroes() {
        try {
            return heroes.getHeroes();
        }catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @Override
    public Heroe getHeroe(int id) {
        try {
            return heroes.getHeroe(id);
        }catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
}

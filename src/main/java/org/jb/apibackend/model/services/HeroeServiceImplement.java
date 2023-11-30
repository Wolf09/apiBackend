package org.jb.apibackend.model.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.jb.apibackend.model.dto.Heroe;
import org.jb.apibackend.model.interfaces.IHeroe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HeroeServiceImplement implements IHeroe {
    @Autowired
    private HeroeServiceImpl heroes;

    @Override
    public List<Heroe> getHeroes() throws JsonProcessingException {
        return heroes.getHeroes();

    }

    @Override
    public Heroe getHeroe(int id) throws JsonProcessingException {
        return heroes.getHeroe(id);
    }
}

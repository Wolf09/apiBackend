package org.jb.apibackend.model.interfaces;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.jb.apibackend.model.dto.Heroe;

import java.util.List;

public interface IHeroe {
    List<Heroe> getHeroes() throws JsonProcessingException;
    Heroe getHeroe(int id) throws JsonProcessingException;
}

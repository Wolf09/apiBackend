package com.example.apibackend.model.services;

import com.example.apibackend.model.interfaces.InterfaceHeroe;
import org.springframework.stereotype.Service;
import org.example.apijar.model.dto.Heroe;
import org.example.apijar.model.services.HeroeServiceImpl;

import java.util.ArrayList;
import java.util.List;
@Service
public class HeroeServiceImplement implements InterfaceHeroe {

    private HeroeServiceImpl heroes;

    public HeroeServiceImplement() {
        this.heroes=new HeroeServiceImpl();
    }

    public HeroeServiceImplement(InterfaceHeroe interfaceHeroe) {
        this.heroes=new HeroeServiceImpl();
    }
    @Override
    public List<Heroe> getHeroes() {
        List<Heroe> heroeList = new ArrayList<>(0);
        try {
            heroeList= heroes.getHeroes();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return heroeList;
    }

    @Override
    public Heroe getHeroe(int id) {
        Heroe her=null;
        try {
            her= heroes.getHeroe(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return her;
    }
}

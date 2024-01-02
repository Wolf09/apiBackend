package com.example.apibackend.model.services;

import com.example.apibackend.model.dao.Bitacora;
import com.example.apibackend.model.interfaces.InterfaceBitacora;
import com.example.apibackend.model.repositories.BitacoraRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BitacoraServiceImplement implements InterfaceBitacora {

    @Autowired
    private BitacoraRepositoryJPA bitacoraRepositoryJPA;

    public BitacoraServiceImplement() {
    }

    public BitacoraServiceImplement(BitacoraRepositoryJPA bitacoraRepositoryJPA) {
        this.bitacoraRepositoryJPA = bitacoraRepositoryJPA;
    }

    @Override
    public Bitacora crearBitacora(Bitacora bitacora) {
        Bitacora bita= null;
        try {
            bita= bitacoraRepositoryJPA.save(bitacora);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return bita;

    }

    @Override
    public List<Bitacora> listarBitacoras(String usuario) {
        List<Bitacora> listaBitacora=new ArrayList<>(0);
        try {
            listaBitacora= bitacoraRepositoryJPA.misBitacoras(usuario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listaBitacora;

    }



}

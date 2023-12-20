package com.example.apibackend.model.services;

import com.example.apibackend.model.dao.Bitacora;
import com.example.apibackend.model.exception.ResourceNotFoundException;
import com.example.apibackend.model.interfaces.BitacoraRepository;
import com.example.apibackend.model.interfaces.BitacoraRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BitacoraServiceImpl implements BitacoraRepository {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private BitacoraRepositoryJPA bitacoraRepositoryJPA;

    @Override
    public Bitacora crearBitacora(Bitacora bitacora) {

        try {
            return bitacoraRepositoryJPA.save(bitacora);
        }catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }

    }

    @Override
    public List<Bitacora> listarBitacoras(String usuario) {
        try {
            return bitacoraRepositoryJPA.misBitacoras(usuario);
        }catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }

    }



}

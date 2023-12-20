package com.example.apibackend.model.interfaces;

import com.example.apibackend.model.dao.Bitacora;

import java.util.List;

public interface BitacoraRepository {
    Bitacora crearBitacora(Bitacora bitacora);
    List<Bitacora> listarBitacoras(String usuario);

}

package com.example.apibackend.model.interfaces;

import com.example.apibackend.model.dao.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BitacoraRepositoryJPA extends JpaRepository<Bitacora,Long> {

    @Query(value = "SELECT b FROM Bitacora b WHERE b.usuario=?1")
    List<Bitacora> misBitacoras(String usuario);


}

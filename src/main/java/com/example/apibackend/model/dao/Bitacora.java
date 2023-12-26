package com.example.apibackend.model.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "bitacoras")
public class Bitacora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String metodo;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp()
    private LocalDateTime bitacora;

    public Bitacora() {
    }

    public Bitacora(Long id, String usuario, String metodo, LocalDateTime bitacora) {
        this.id = id;
        this.usuario = usuario;
        this.metodo = metodo;
        this.bitacora = bitacora;
    }
//    public Bitacora(String usuario, String metodo, LocalDateTime bitacora) {
//        this.usuario = usuario;
//        this.metodo = metodo;
//        this.bitacora = bitacora;
//    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public LocalDateTime getBitacora() {
        return bitacora;
    }

    public void setBitacora(LocalDateTime bitacora) {
        this.bitacora = bitacora;
    }
}

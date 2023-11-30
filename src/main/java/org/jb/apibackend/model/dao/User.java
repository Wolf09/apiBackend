package org.jb.apibackend.model.dao;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user", length = 120)
    private String user;
    @Column(name="user", length = 120)
    private LocalDateTime tiempo;

    public User() {
    }

    public User(Long id, String user, LocalDateTime tiempo) {
        this.id = id;
        this.user = user;
        this.tiempo = tiempo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalDateTime tiempo) {
        this.tiempo = tiempo;
    }
}

package com.example.apibackend.model.services;


import org.example.apijar.model.dto.Heroe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HeroeServiceImplementTest {

    @Mock
    HeroeServiceImplement heroeServiceImplement;

    @Test
    void getHeroesTest(){
        when(heroeServiceImplement.getHeroes()).thenReturn(Datos.HEROES);
        List<Heroe> heroes=heroeServiceImplement.getHeroes();
        assertNotNull(heroes);
        assertTrue(heroes.size()>0);
        assertEquals(5,heroes.size());

    }

    @Test
    void getHeroesporIdTest() {
        when(heroeServiceImplement.getHeroe(11111)).thenReturn(Datos.buscarHero(11111));
        Heroe heroe=heroeServiceImplement.getHeroe(11111);
        assertNotNull(heroe);
        assertEquals("Integer",((Object)heroe.getId()).getClass().getSimpleName());
    }

}
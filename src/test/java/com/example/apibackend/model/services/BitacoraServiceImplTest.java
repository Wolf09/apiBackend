package com.example.apibackend.model.services;

import com.example.apibackend.model.dao.Bitacora;
import com.example.apibackend.model.interfaces.BitacoraRepositoryJPA;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BitacoraServiceImplTest{

    @Mock
    BitacoraRepositoryJPA bitacoraRepositoryJPA;

    @InjectMocks
    BitacoraServiceImplement bitacoraServiceImplement;

    @Test
    void listarBitacorasTest() {
        when(bitacoraRepositoryJPA.misBitacoras("3F-4H-6G-7L")).thenReturn(Datos.BITACORAS);
        List<Bitacora> bitacoras= bitacoraServiceImplement.listarBitacoras("3F-4H-6G-7L");
        assertNotNull(bitacoras);
        assertTrue(bitacoras.size()>0);
        assertEquals(4,bitacoras.size());

    }

    @Test
    void crearBitacoraTest() {
        Bitacora nuevaBitacora= Datos.BITACORA;
        when(bitacoraRepositoryJPA.save(any(Bitacora.class))).then(new Answer<Bitacora>() {
            Long secuencia=5L;
            @Override
            public Bitacora answer(InvocationOnMock invocation) throws Throwable {
                Bitacora bitacora= invocation.getArgument(0);
                bitacora.setId(secuencia++);
                return bitacora;
            }

        });
        Bitacora bitacoraGuardada= bitacoraServiceImplement.crearBitacora(nuevaBitacora);
        assertNotNull(bitacoraGuardada);
        assertEquals(5L,bitacoraGuardada.getId());
        assertEquals("3F-4H-6G-7L",bitacoraGuardada.getUsuario());
    }
}


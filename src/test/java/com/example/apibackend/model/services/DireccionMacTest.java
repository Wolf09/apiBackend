package com.example.apibackend.model.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DireccionMacTest {

    @Test
    void getAddressTest() {
        DireccionMac direccionMac=new DireccionMac();
        String miMac= direccionMac.GetAddress("mac");
        assertNotNull(miMac);
        assertEquals("String",((Object)miMac).getClass().getSimpleName());
    }
}
package com.example.apibackend.controller;

import com.example.apibackend.model.dao.Bitacora;
import com.example.apibackend.model.services.BitacoraServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class BitacoraController {

    @Autowired
    private BitacoraServiceImplement bitacoraService;

    @GetMapping("/bitacoras/{user}")
    public ResponseEntity<List<Bitacora>> allBitacoras(@PathVariable String user){
        ResponseEntity<List<Bitacora>> resp=null;
        try{
            resp=new ResponseEntity<>(bitacoraService.listarBitacoras(user), HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return resp;
    }

    @PostMapping("/bitacoras/crear")
    public ResponseEntity<Bitacora> crearBitacora(@RequestBody Bitacora bit){
        ResponseEntity<Bitacora> resp=null;
        try{
            resp=new ResponseEntity<>(bitacoraService.crearBitacora(bit), HttpStatus.CREATED);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

        return resp;
    }


}

package com.example.apibackend.controller;

import com.example.apibackend.model.dto.Mac;
import com.example.apibackend.model.services.DireccionMac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class MacController {
    @Autowired
    private DireccionMac direccionMac;

    @GetMapping("/mac")
    public ResponseEntity<Mac> obtenerMac(){
        Mac mac = new Mac();
        ResponseEntity<Mac> resp=null;
        try {
            mac.setMiMac(direccionMac.GetAddress("mac"));
            resp=new ResponseEntity<>(mac, HttpStatus.OK);

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }


        return resp;
    }


}

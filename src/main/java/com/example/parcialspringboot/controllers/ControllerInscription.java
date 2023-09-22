package com.example.parcialspringboot.controllers;

import com.example.parcialspringboot.entities.Inscription;
import com.example.parcialspringboot.responses.ResponseHandler;
import com.example.parcialspringboot.services.ServiceInscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/inscriptions")
public class ControllerInscription {

    @Autowired
    private ServiceInscription serviceInscription;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Inscription inscription){
        try {

            Inscription inscription1= serviceInscription.save(inscription);
            inscription1.setFinalValue(inscription1.getParticipant().getTypeParticipant()?inscription1.getEvent().getValue()*0.70:inscription1.getEvent().getValue());
            Inscription inscription2= serviceInscription.save(inscription1);
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, inscription2);
        }catch (Exception e){
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    @GetMapping("/totalInscripciones")
    public ResponseEntity<Object> sum(){
        try {

            double total = serviceInscription.sum();
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, total);
        }catch (Exception e){
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}

package com.example.parcialspringboot.controllers;

import com.example.parcialspringboot.entities.Participant;
import com.example.parcialspringboot.services.ServiceParticipant;
import com.example.parcialspringboot.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/participants")
public class ControllerParticipant {

    @Autowired
    private ServiceParticipant serviceParticipant;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Participant participant){
        try {
            Participant participant1 = serviceParticipant.save(participant);
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, participant1);
        }catch (Exception e){
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}

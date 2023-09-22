package com.example.parcialspringboot.controllers;


import com.example.parcialspringboot.entities.Activity;
import com.example.parcialspringboot.entities.Event;
import com.example.parcialspringboot.entities.Participant;
import com.example.parcialspringboot.responses.ResponseHandler;
import com.example.parcialspringboot.services.ServiceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class ControllerEvent {
    @Autowired
    private ServiceEvent serviceEvent;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        try {
            List<Event> events = serviceEvent.findAll();
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, events);
        }catch (Exception e){
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/listPart/{id}")
    public ResponseEntity<Object> findList(@PathVariable int id){
        try {
            List<Participant> participants = serviceEvent.findList(id);
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, participants);
        }catch (Exception e){
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    @GetMapping("/calendar/{idEvent}&{idParticipant}")
    public ResponseEntity<Object> findList(@PathVariable int idEvent, @PathVariable int idParticipant){
        try {
            List<Activity> calendar = serviceEvent.findCalendar(idEvent,idParticipant);
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, calendar);
        }catch (Exception e){
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Event event){
        try {
            Event event1 = serviceEvent.save(event);
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, event1);
        }catch (Exception e){
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}

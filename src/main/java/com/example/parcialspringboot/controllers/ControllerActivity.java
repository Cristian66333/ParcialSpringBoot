package com.example.parcialspringboot.controllers;


import com.example.parcialspringboot.entities.Activity;
import com.example.parcialspringboot.responses.ResponseHandler;
import com.example.parcialspringboot.services.ServiceActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/activities")
public class ControllerActivity {

    @Autowired
    private ServiceActivity serviceActivity;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Activity activity){
        try {
            Activity activity1= serviceActivity.save(activity);
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, activity1);
        }catch (Exception e){
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}

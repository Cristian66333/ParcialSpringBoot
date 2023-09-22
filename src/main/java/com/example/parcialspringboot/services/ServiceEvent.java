package com.example.parcialspringboot.services;


import com.example.parcialspringboot.entities.Activity;
import com.example.parcialspringboot.entities.Event;
import com.example.parcialspringboot.entities.Inscription;
import com.example.parcialspringboot.entities.Participant;
import com.example.parcialspringboot.repositories.RepositoryEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEvent {

    @Autowired
    private RepositoryEvent repositoryEvent;

    public Event save(Event event){
        return repositoryEvent.save(event);
    }

    public List<Event> findAll(){
        return repositoryEvent.findAll();
    }
    public List<Participant> findList(int id){
        Optional<Event> optionalEvent = repositoryEvent.findById(id);
        List<Participant> participants = new ArrayList<>();
        Event event = optionalEvent.isPresent()? optionalEvent.get() : null;
        for (Inscription ins: event.getInscriptions()){
            participants.add(ins.getParticipant());
        }

        return participants;
    }
    public List<Activity> findCalendar(int idEvent, int idParticipant){
        Optional<Event> optionalEvent = repositoryEvent.findById(idEvent);
        List<Participant> participants = new ArrayList<>();
        Event event = optionalEvent.isPresent()? optionalEvent.get() : null;
        for (Inscription ins: event.getInscriptions()){
            if (ins.getParticipant().getIdParticipant()==idParticipant){
                return ins.getEvent().getActivities();
            }

        }
        return null;
    }
}

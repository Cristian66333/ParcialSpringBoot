package com.example.parcialspringboot.services;

import com.example.parcialspringboot.entities.Participant;
import com.example.parcialspringboot.repositories.RepositoryParticipant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceParticipant {

    @Autowired
    private RepositoryParticipant repositoryParticipant;

    public Participant save(Participant participant){
        return repositoryParticipant.save(participant);
    }
}

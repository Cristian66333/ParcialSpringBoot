package com.example.parcialspringboot.services;

import com.example.parcialspringboot.entities.Inscription;
import com.example.parcialspringboot.repositories.RepositoryInscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceInscription {
    @Autowired
    private RepositoryInscription repositoryInscription;

    public Inscription save(Inscription inscription){

        return repositoryInscription.save(inscription);
    }

    public double sum(){
        List<Inscription> inscriptions= repositoryInscription.findAll();
        double suma=0;
        for (Inscription ins: inscriptions){
            suma +=ins.getFinalValue();
        }
        return suma;
    }
}

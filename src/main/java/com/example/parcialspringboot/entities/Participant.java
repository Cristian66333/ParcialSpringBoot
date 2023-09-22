package com.example.parcialspringboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_participant", nullable = false)
    private int idParticipant;

    @Column
    private String name;

    @Column
    private String document;

    @Column(name = "type_participant")
    private boolean typeParticipant;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Inscription> inscriptions = new ArrayList<>();

    public boolean isTypeParticipant() {
        return typeParticipant;
    }

    public Collection<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Collection<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public boolean getTypeParticipant() {
        return typeParticipant;
    }

    public void setTypeParticipant(boolean typeParticipant) {
        this.typeParticipant = typeParticipant;
    }

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }
}

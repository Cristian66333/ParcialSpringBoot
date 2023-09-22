package com.example.parcialspringboot.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Inscription {
    @EmbeddedId
    private InscriptionKey id = new InscriptionKey();
    @ManyToOne
    @MapsId("idParticipant")
    @JoinColumn(name = "id_participant")
    private Participant participant;

    @ManyToOne
    @MapsId("idEvent")
    @JoinColumn(name = "id_event")
    private Event event;

    @Column(name = "final_value", scale = 2)
    private double finalValue;

    public Inscription() {
    }

    public InscriptionKey getId() {
        return id;
    }

    public void setId(InscriptionKey id) {
        this.id = id;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public double getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(double finalValue) {
        this.finalValue = finalValue;
    }
}

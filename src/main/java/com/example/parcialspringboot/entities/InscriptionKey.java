package com.example.parcialspringboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InscriptionKey implements Serializable {
    @Column(name = "id_participant")
    private int idParticipant;

    @Column(name = "id_event")
    private int idEvent;

    public InscriptionKey() {
    }

    public InscriptionKey(int idParticipant, int idEvent) {
        this.idParticipant = idParticipant;
        this.idEvent = idEvent;
    }

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscriptionKey that = (InscriptionKey) o;
        return idParticipant == that.idParticipant && idEvent == that.idEvent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParticipant, idEvent);
    }


}

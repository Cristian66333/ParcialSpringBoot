package com.example.parcialspringboot.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_activity", nullable = false)
    private int idActivity;

    @Column
    private String name;

    @Column(name = "date_activity")
    private LocalDate dateActivity;

    @Column(name = "time_activity")
    private LocalTime timeActivity;

    @Column(name = "description_activity")
    private String descriptionActivity;

    @ManyToOne
    @JoinColumn(name = "event", nullable = false)
    private Event event;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateActivity() {
        return dateActivity;
    }

    public void setDateActivity(LocalDate dateActivity) {
        this.dateActivity = dateActivity;
    }

    public LocalTime getTimeActivity() {
        return timeActivity;
    }

    public void setTimeActivity(LocalTime timeActivity) {
        this.timeActivity = timeActivity;
    }

    public String getDescriptionActivity() {
        return descriptionActivity;
    }

    public void setDescriptionActivity(String descriptionActivity) {
        this.descriptionActivity = descriptionActivity;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }
}

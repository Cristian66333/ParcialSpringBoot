package com.example.parcialspringboot.repositories;

import com.example.parcialspringboot.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEvent extends JpaRepository<Event,Integer> {
}

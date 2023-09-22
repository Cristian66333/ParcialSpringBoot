package com.example.parcialspringboot.repositories;

import com.example.parcialspringboot.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryParticipant extends JpaRepository<Participant,Integer> {
}

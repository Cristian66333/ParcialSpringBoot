package com.example.parcialspringboot.repositories;

import com.example.parcialspringboot.entities.Inscription;
import com.example.parcialspringboot.entities.InscriptionKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryInscription extends JpaRepository<Inscription, InscriptionKey> {
}

package com.example.parcialspringboot.repositories;

import com.example.parcialspringboot.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryActivity extends JpaRepository<Activity,Integer> {
}

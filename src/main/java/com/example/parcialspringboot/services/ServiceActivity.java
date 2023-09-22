package com.example.parcialspringboot.services;


import com.example.parcialspringboot.entities.Activity;
import com.example.parcialspringboot.repositories.RepositoryActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceActivity {
    @Autowired
    private RepositoryActivity repositoryActivity;

    public Activity save(Activity activity){
        return repositoryActivity.save(activity);
    }
}

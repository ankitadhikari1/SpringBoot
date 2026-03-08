package com.project;

import com.project.entity.Alien;
import com.project.repo.IAlien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataJPARunner implements CommandLineRunner {

    @Autowired
    private IAlien repo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(repo.getClass().getName());
        repo.save(new Alien(2,"Deepak","Haldwani"));
    }
}

package com.project.repo;

import com.project.entity.Alien;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlien extends CrudRepository<Alien,Integer> {

}

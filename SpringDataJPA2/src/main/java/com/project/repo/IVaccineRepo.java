package com.project.repo;

import com.project.entity.Vaccine;
import org.springframework.data.repository.CrudRepository;

public interface IVaccineRepo extends CrudRepository<Vaccine,Integer> {

}

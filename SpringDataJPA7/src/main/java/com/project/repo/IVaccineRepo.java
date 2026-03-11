package com.project.repo;


import com.project.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer> {

    // findBy + propertyName + keyword


    public List<Vaccine> findByCost(Double cost);

    public List<Vaccine> findByCostLessThanEqual(Double cost);

    public List<Vaccine> findByVaccineNameEquals(String name);



}

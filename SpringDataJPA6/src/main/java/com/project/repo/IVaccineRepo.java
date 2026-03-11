package com.project.repo;


import com.project.entity.Vaccine;
import com.project.view.View;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer> {

    // findBy + propertyName + keyword
    public <T extends View>List<T> findByCostLessThan(Double cost, Class<T> cls);




}

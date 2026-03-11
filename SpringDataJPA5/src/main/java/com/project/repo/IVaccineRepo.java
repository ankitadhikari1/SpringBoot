package com.project.repo;

import com.project.entity.Vaccine;
import com.project.view.ResultView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer> {

    // findBy + propertyName + keyword

     List<ResultView> findByCostLessThan(Double cost);


}

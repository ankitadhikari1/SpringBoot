package com.project.service;



import com.project.entity.Vaccine;

import java.util.List;

public interface IVaccineService {

    public List<Vaccine> fetchByCost(Double amount);
    public List<Vaccine> fetchByCostLessThanEqual(Double cost);
    public List<Vaccine> fetchByVaccineNameEquals(String name);

}

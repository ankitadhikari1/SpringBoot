package com.project.service;

import com.project.entity.Vaccine;
import com.project.repo.IVaccineRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VaccineService implements IVaccineService{

    private IVaccineRepo repo;

    @Autowired
    public void setRepo(IVaccineRepo repo) {
        this.repo = repo;
    }


    @Override
    public List<Vaccine> fetchByCost(Double amount) {
        return repo.findByCost(amount);
    }

    @Override
    public List<Vaccine> fetchByCostLessThanEqual(Double cost) {
        return repo.findByCostLessThanEqual(cost);
    }

    @Override
    public List<Vaccine> fetchByVaccineNameEquals(String name) {
        return repo.findByVaccineNameEquals(name);
    }
}

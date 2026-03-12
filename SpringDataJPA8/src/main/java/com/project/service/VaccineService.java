package com.project.service;

import com.project.entity.Vaccine;
import com.project.repo.IVaccineRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VaccineService implements IVaccineService {

    private IVaccineRepo repo;

    @Autowired
    public void setRepo(IVaccineRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Vaccine> fetchByVaccineCompany(String companyName) {
        return repo.searchByVaccineCompany(companyName);
    }

    @Override
    public List<Vaccine> fetchByVaccineCompany(String companyName1, String companyName2) {
        return repo.searchByVaccineCompany(companyName1,companyName2);
    }

    @Override
    public List<Vaccine> fetchVaccineByCost(Double cost) {
        return repo.searchVaccineByCost(cost);
    }

    @Override
    public int updateThePriceByVaccineName(Double price, String name) {
        return repo.updatePriceByVaccineName(price,name);
    }
}


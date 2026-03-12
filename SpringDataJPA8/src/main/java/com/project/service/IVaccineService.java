package com.project.service;



import com.project.entity.Vaccine;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVaccineService {
    public List<Vaccine> fetchByVaccineCompany(String companyName);
    public List<Vaccine> fetchByVaccineCompany(String companyName1,String companyName2);
    public List<Vaccine> fetchVaccineByCost(Double cost);
    public int updateThePriceByVaccineName(Double price , String name);
}

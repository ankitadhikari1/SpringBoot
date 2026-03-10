package com.project.service;

import com.project.entity.Vaccine;

import java.util.List;

public interface IVaccineService {

    public Vaccine searchVaccineById(int id);
    public List<Vaccine> searchVaccineByGivenInfo(Vaccine vac );
    public String removeVaccineByIds(Iterable<Integer>ids);

}

package com.project.service;

import com.project.entity.Vaccine;

public interface IVaccineService {
    public String registerVaccineInfo(Vaccine vaccine);
    public Iterable<Vaccine> registerMultipleVaccineInfo(Iterable<Vaccine> vaccine);
    public long vaccineCount();
    public Boolean checkVaccineAvailability(Integer id);
    public Iterable<Vaccine> getAllVaccineInfo();
}

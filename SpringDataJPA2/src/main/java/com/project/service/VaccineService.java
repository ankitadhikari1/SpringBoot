package com.project.service;

import com.project.entity.Vaccine;
import com.project.repo.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VaccineService implements IVaccineService{

    private IVaccineRepo repo;

    @Autowired
    public void setRepo(IVaccineRepo repo) {
        this.repo = repo;
    }

    @Override
    public String registerVaccineInfo(Vaccine vaccine) {
        Vaccine vaccine1= repo.save(vaccine);
        return "Vaccine info registered with id " + vaccine1.getId();
    }

    @Override
    public Iterable<Vaccine> registerMultipleVaccineInfo(Iterable<Vaccine> vaccine) {
        return repo.saveAll(vaccine);
    }

    @Override
    public long vaccineCount() {
        return repo.count();
    }

    @Override
    public Boolean checkVaccineAvailability(Integer id) {
        return repo.existsById(id);
    }

    @Override
    public Iterable<Vaccine> getAllVaccineInfo() {
        return repo.findAll();
    }
}

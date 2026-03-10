package com.project.service;

import com.project.entity.Vaccine;
import com.project.repo.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
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
    public Vaccine searchVaccineById(int id) {
        return repo.getReferenceById(id);
    }

    @Override
    public List<Vaccine> searchVaccineByGivenInfo(Vaccine vac) {
        Example<Vaccine> example =Example.of(vac);
        return repo.findAll(example);
    }

    @Override
    public String removeVaccineByIds(Iterable<Integer> ids) {
        List<Vaccine> list = repo.findAllById(ids);
        if(!list.isEmpty()){
            repo.deleteAll(list);
            return "Record deleted for given ids";
        }
        return "No record found for given ids";
    }


}

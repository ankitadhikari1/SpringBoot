package com.project.service;

import com.project.entity.Vaccine;
import com.project.repo.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Iterable<Vaccine> fetchDetailsBySorting(boolean status, String... properties) {
        Sort sort = Sort.by(status ? Sort.Direction.ASC : Sort.Direction.DESC, properties);
        return repo.findAll(sort);
    }

    @Override
    public List<Vaccine> fetchDetailsByPagenation(int pageNo, int pageSize, boolean status, String... properties) {
        Sort sort = Sort.by(status ? Sort.Direction.ASC : Sort.Direction.DESC, properties);
        PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Vaccine> page = repo.findAll(pageable);
        return page.getContent();
    }

    @Override
    public void fetchDetailsByPagenation(int pageSize) {
        long count = repo.count();
        int totalPages = (int) Math.ceil((double) count / pageSize);
        for (int pageNo = 0; pageNo < totalPages; pageNo++) {
            PageRequest pageable = PageRequest.of(pageNo, pageSize);
            Page<Vaccine> page = repo.findAll(pageable);
            List<Vaccine> vaccines = page.getContent();
            vaccines.forEach(System.out::println);
            System.out.println("------------------------------");
        }
    }
}

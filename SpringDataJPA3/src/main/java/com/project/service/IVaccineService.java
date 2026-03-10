package com.project.service;

import com.project.entity.Vaccine;

import java.util.List;

public interface IVaccineService {

    public Iterable<Vaccine> fetchDetailsBySorting(boolean status , String... properties);
    public List<Vaccine> fetchDetailsByPagenation(int pageNo , int pageSize ,boolean status , String... properties);
    public void fetchDetailsByPagenation(int pageSize);

}

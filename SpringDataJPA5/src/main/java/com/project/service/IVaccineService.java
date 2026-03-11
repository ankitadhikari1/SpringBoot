package com.project.service;

import com.project.entity.Vaccine;
import com.project.view.ResultView;

import java.util.List;

public interface IVaccineService {
    public List<ResultView> fetchByCost(Double cost);


}

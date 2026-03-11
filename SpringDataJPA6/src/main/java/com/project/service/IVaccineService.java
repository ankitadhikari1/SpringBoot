package com.project.service;

import com.project.view.View;

import java.util.List;

public interface IVaccineService {
    public <T extends View>List<T> fetchByCostLessThan(Double cost, Class<T> cls);


}

package com.project.service;

import com.project.dto.CustomerDTO;
import com.project.model.Customer;

import java.util.List;

public interface ICostumerService {
    public String registerCustomer(CustomerDTO dto);
    public List<Customer> findAllCustomer();
}

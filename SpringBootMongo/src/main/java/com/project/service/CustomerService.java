package com.project.service;

import com.project.dto.CustomerDTO;
import com.project.model.Customer;
import com.project.repo.ICustomerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICostumerService{

    @Autowired
    private ICustomerRepo repo;


    @Override
    public String registerCustomer(CustomerDTO dto) {
        Customer cos = new Customer();
        BeanUtils.copyProperties(dto,cos);
        Customer res = repo.save(cos);
        return "Customer saved with id "+res.getId();
    }

    @Override
    public List<Customer> findAllCustomer() {
        return repo.findAll();
    }
}

package com.project.rest;

import com.project.model.customer.Customer;
import com.project.model.product.Product;
import com.project.repo.cx.ICustomerRepo;
import com.project.repo.pd.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MultiDbController {

    @Autowired
    private ICustomerRepo repo1;

    @Autowired
    private IProductRepo repo2;

    @GetMapping("/getallcx")
    public List<Customer> getAllCx(){
        return repo1.findAll();
    }

    @GetMapping("/getallpd")
    public List<Product> getAllPd(){
        return repo2.findAll();
    }
}

package com.project.repo;

import com.project.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICustomerRepo extends MongoRepository<Customer,String> {
}

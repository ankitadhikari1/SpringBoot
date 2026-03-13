package com.project.repo.pd;

import com.project.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product,Integer> {

}

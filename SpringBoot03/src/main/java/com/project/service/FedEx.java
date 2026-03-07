package com.project.service;


import org.springframework.stereotype.Service;

@Service
public class FedEx implements IDelivery{

    public FedEx(){
        System.out.println("fedex bean is created");
    }

    @Override
    public Boolean deliverTheProduct(Double amount) {
        System.out.println("product delivered with fedEx and amount paid is "+amount);
        return true;
    }
}

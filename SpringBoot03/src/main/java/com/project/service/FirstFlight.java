package com.project.service;


import org.springframework.stereotype.Service;

@Service
public class FirstFlight implements IDelivery{

    public FirstFlight(){
        System.out.println("First flight bean created");
    }
    @Override
    public Boolean deliverTheProduct(Double amount) {
        System.out.println("product delivered with first flight and amount paid is "+amount);
        return true;
    }
}

package com.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Amazon {


    private IDelivery service;

    public Amazon(){
        System.out.println("Amazon bean created");
    }

    @Autowired
    @Qualifier("fedEx")
    public void setService(IDelivery service) {
        this.service = service;
    }

    public Boolean deliverProduct(Double amount){
        return service.deliverTheProduct(amount);
    }
}

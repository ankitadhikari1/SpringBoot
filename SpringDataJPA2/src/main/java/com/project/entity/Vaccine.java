package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vaccine
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String vaccineName;
    private String vaccineCompany;
    private Double cost;

    public Vaccine(){

    }

    public Vaccine(String vaccineName, String vaccineCompany, Double cost) {
        this.vaccineName = vaccineName;
        this.vaccineCompany = vaccineCompany;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", vaccineName='" + vaccineName + '\'' +
                ", vaccineCompany='" + vaccineCompany + '\'' +
                ", cost=" + cost +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineCompany() {
        return vaccineCompany;
    }

    public void setVaccineCompany(String vaccineCompany) {
        this.vaccineCompany = vaccineCompany;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}


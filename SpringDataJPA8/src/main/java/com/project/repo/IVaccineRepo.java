package com.project.repo;


import com.project.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer> {

    //@Query("FROM Vaccine where vaccineCompany =:company")
    //public List<Vaccine> searchByVaccineCompany(String company);

    @Query("FROM Vaccine where vaccineCompany =:company")
    public List<Vaccine> searchByVaccineCompany(@Param("company")String companyName);

    @Query("FROM Vaccine where vaccineCompany in (:company1,:company2)")
    public List<Vaccine> searchByVaccineCompany(@Param("company1")String companyName1 , @Param("company2")String companyName2);

    @Query("FROM Vaccine where cost =:cost")
    public List<Vaccine> searchVaccineByCost(Double cost);

    @Transactional
    @Modifying
    @Query("Update Vaccine set cost=:price where vaccineName=:name ")
    public int updatePriceByVaccineName(Double price , String name);
}

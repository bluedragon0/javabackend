package com.abdo.project.controllers;


import com.abdo.project.dao.InsuranceDao;
import com.abdo.project.models.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class InsuranceController {

    @Autowired
    InsuranceDao  insuranceDao;

    @PostMapping("/insurance")
    public Insurance createinsurance(@Valid @RequestBody Insurance insurance){

        return insuranceDao.save(insurance);
    }

    //@RequestMapping(value = "/signup", method = RequestMethod.GET)
    @GetMapping("/insurance")
    public List<Insurance> getAllInsurance(){
        return insuranceDao.findAll();
    }

    @GetMapping("insurance/{id}")

    public ResponseEntity<Insurance> getInsuranceById (@PathVariable (value = "id") Long id)
    {
        Insurance insurance = insuranceDao.getemp(id);
        if (insurance == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(insurance);
    }
    @PutMapping("/insurance/{id}")
    public ResponseEntity<Insurance> updateProjectById(@PathVariable(value = "id")Long  id,@Valid @RequestBody Insurance insurance ) {
        Insurance en = insuranceDao.getemp(id);
        if (en == null)
            return ResponseEntity.notFound().build();
        else {
            en.setEmployee(insurance.getEmployee());
            en.setStartDate(insurance.getStartDate());
            en.setAgancyName(insurance.getAgancyName());
            en.setEndDate(insurance.getEndDate());
            Insurance updated = insuranceDao.save(en);
            return ResponseEntity.ok().body(updated);
        }


    }
    @DeleteMapping("/insurance/{id}")
    public ResponseEntity<Insurance> deleteInsurance(@PathVariable(value = "id") Long id){
        Insurance insurance = insuranceDao.getemp(id);
        if (insurance == null)
            return ResponseEntity.notFound().build();

        insuranceDao.delete(insurance);

        return ResponseEntity.ok().build();


    }





}

package com.abdo.project.dao;

import com.abdo.project.exception.ResourceNotFoundException;
import com.abdo.project.models.Insurance;
import com.abdo.project.repositery.InsuranceRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Service
public class InsuranceDao  {
   @Autowired
   InsuranceRepositery insuranceRepositery;


   public Insurance save (Insurance insurance)
   {
       return insuranceRepositery.save(insurance);
   }

    public List<Insurance> findAll()
    {
        return insuranceRepositery.findAll();
    }

    public Insurance getemp (@PathVariable(value = "id")  Long id){

        return insuranceRepositery.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
    }

    public void delete (Insurance insurance){

        insuranceRepositery.delete(insurance);

    }

}

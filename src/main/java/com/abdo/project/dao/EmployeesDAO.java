package com.abdo.project.dao;

import com.abdo.project.exception.ResourceNotFoundException;
import com.abdo.project.models.Employees;
import com.abdo.project.models.Projects;
import com.abdo.project.repositery.EmployeesRepossitery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeesDAO {
     @Autowired
     EmployeesRepossitery employeesRepossitery ;

     public Employees save (Employees emp )
     {
         return employeesRepossitery.save(emp);
     }

     public List<Employees> findAll()
     {
         return employeesRepossitery.findAll();
     }

    public Employees getemp (@PathVariable(value = "id")  Long id){

        return employeesRepossitery.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
    }

     public void delete (Employees emp){

         employeesRepossitery.delete(emp);

     }



}

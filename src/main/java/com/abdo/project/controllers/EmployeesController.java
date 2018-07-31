package com.abdo.project.controllers;

import com.abdo.project.dao.EmployeesDAO;
import com.abdo.project.models.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/index")
public class EmployeesController {
    @Autowired
    EmployeesDAO employeesDAO;

    @PostMapping("/employees")
    public Employees createEmp(@Valid @RequestBody Employees employees) {
        return employeesDAO.save(employees);
    }

    @GetMapping("/employees")
    public List<Employees> findAll() {
        return employeesDAO.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employees> getProjectById(@PathVariable(value = "id") Long id) {
        Employees employees = employeesDAO.getemp(id);
        if (employees == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(employees);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employees> updateProjectById(@PathVariable(value = "id") Long id, @Valid @RequestBody Employees employees) {
        Employees employee = employeesDAO.getemp(id);
        if (employee == null)
            return ResponseEntity.notFound().build();
        else {
            employee.setName(employees.getName());
            employee.setHiringDate(employees.getHiringDate());
            employee.setInsurance(employees.getInsurance());
            employee.setJobTitle(employees.getJobTitle());
            employee.setPassword(employees.getPassword());
            employee.setSalary(employees.getSalary());
            employee.setProject(employees.getProject());
            employee.setUserName(employees.getUserName());

            Employees updated = employeesDAO.save(employee);
            return ResponseEntity.ok().body(updated);
        }

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employees> deleteProject(@PathVariable(value = "id") Long id){
        Employees employees = employeesDAO.getemp(id);
        if (employees == null)
            return ResponseEntity.notFound().build();

        employeesDAO.delete(employees);

        return ResponseEntity.ok().build();


    }
}
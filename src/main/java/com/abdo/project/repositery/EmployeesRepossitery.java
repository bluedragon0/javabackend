package com.abdo.project.repositery;

import com.abdo.project.models.Employees;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface EmployeesRepossitery extends JpaRepository<Employees,Long> {




}

package com.abdo.project.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    private String name;
    private int hours;
    @ManyToMany(mappedBy = "project")
    private Set <Employees> employee ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Set<Employees> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employees> employee) {
        this.employee = employee;
    }
}

package com.abdo.project.repositery;

import com.abdo.project.models.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectsRepositery extends CrudRepository<Projects,Long> {





}

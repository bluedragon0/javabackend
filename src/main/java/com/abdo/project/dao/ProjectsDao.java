package com.abdo.project.dao;

import com.abdo.project.exception.ResourceNotFoundException;
import com.abdo.project.models.Projects;
import com.abdo.project.repositery.ProjectsRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectsDao  {

    @Autowired
    ProjectsRepositery projectsRepositery;

    public Projects save (Projects projects)
    {
        return projectsRepositery.save(projects);

    }

    public Projects getProjectById (@PathVariable (value = "id")  Long id){

      return projectsRepositery.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
    }

    public List<Projects> findAll()
    {
        return (List<Projects>) projectsRepositery.findAll();
    }

    public void delete (Projects projects)
    {
        projectsRepositery.delete(projects);

    }


}

package com.abdo.project.controllers;

import com.abdo.project.dao.ProjectsDao;
import com.abdo.project.models.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class ProjectsController {

    @Autowired
    ProjectsDao projectsDao;

    @PostMapping("/projects")
    public Projects createProject(@Valid @RequestBody Projects projects){

        return projectsDao.save(projects);
    }

    //@RequestMapping(value = "/signup", method = RequestMethod.GET)
    @GetMapping("/projects")
    public List<Projects> getAllProjects(){
        return projectsDao.findAll();
    }

    @GetMapping("projects/{id}")

    public ResponseEntity<Projects> getProjectById (@PathVariable (value = "id") Long id)
    {
        Projects project = projectsDao.getProjectById(id);
        if (project == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(project);
    }
    @PutMapping("/projects/{id}")
    public ResponseEntity<Projects> updateProjectById(@PathVariable(value = "id")Long  id,@Valid @RequestBody Projects projects ) {
        Projects project = projectsDao.getProjectById(id);
        if (project == null)
            return ResponseEntity.notFound().build();
        else {
            project.setEmployee(projects.getEmployee());
            project.setHours(projects.getHours());
            project.setName(projects.getName());

            Projects updated = projectsDao.save(project);
            return ResponseEntity.ok().body(updated);
        }


    }
        @DeleteMapping("/projects/{id}")
        public ResponseEntity<Projects> deleteProject(@PathVariable(value = "id") Long id){
        Projects project = projectsDao.getProjectById(id);
        if (project == null)
            return ResponseEntity.notFound().build();

        projectsDao.delete(project);

        return ResponseEntity.ok().build();


    }






}

package com.digitas.jobs.controller;

import com.digitas.jobs.controller.dto.ProjectDTO;
import com.digitas.jobs.controller.dto.ProjectResponseDTO;
import com.digitas.jobs.domain.Project;
import com.digitas.jobs.service.impl.ProjectServiceImpl;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/projects")
public class ProjectController {

    private ProjectServiceImpl projectService;

    @Autowired
    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "{id}")
    @ApiOperation(value = "Get Project by Id")
    public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable("id") Long id) {
        ProjectResponseDTO responseDTO = projectService.retrieveProjectById(id);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create Project")
    public ResponseEntity<Project> createProject(@NotNull @RequestBody ProjectDTO projectDTO,
                                                 @RequestParam("sellerId") Long sellerId) {
        Project newProject = projectService.addProject(projectDTO, sellerId);

        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    @ApiOperation(value = "Update Project")
    public ResponseEntity<Project> updateProject(@PathVariable("id") Long id,
                                               @NotNull @RequestBody ProjectDTO projectDTO) {
        Project updatedProject = projectService.updateProject(id, projectDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    @ApiOperation(value = "Delete Project by Id")
    public ResponseEntity deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}

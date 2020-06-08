package com.digitas.jobs.service;

import com.digitas.jobs.controller.dto.ProjectDTO;
import com.digitas.jobs.controller.dto.ProjectResponseDTO;
import com.digitas.jobs.domain.Project;

public interface ProjectService {

    ProjectResponseDTO retrieveProjectById(Long id);

    Project addProject(ProjectDTO projectDTO, Long sellerId);

    Project updateProject(Long id, ProjectDTO projectDTO);

    void deleteProject(Long id);
}

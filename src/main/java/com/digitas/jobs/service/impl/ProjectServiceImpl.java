package com.digitas.jobs.service.impl;

import com.digitas.jobs.controller.dto.ProjectDTO;
import com.digitas.jobs.controller.dto.ProjectResponseDTO;
import com.digitas.jobs.domain.Bid;
import com.digitas.jobs.domain.Project;
import com.digitas.jobs.error.ResourceNotFoundException;
import com.digitas.jobs.repository.ProjectRepository;
import com.digitas.jobs.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private SellerServiceImpl sellerService;
    private ModelMapper modelMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository,
                              ModelMapper modelMapper,
                              SellerServiceImpl sellerService) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
        this.sellerService = sellerService;
    }

    @Override
    public ProjectResponseDTO retrieveProjectById(Long id) {
        Project project =projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        Bid lowestBid = findLowestBid(project.getBids());
        ProjectResponseDTO responseDTO = modelMapper.map(project,ProjectResponseDTO.class);
        responseDTO.setActive(isActive(project));
        responseDTO.setLowestBid(lowestBid);
         return  responseDTO;
    }

    @Override
    public Project addProject(ProjectDTO projectDTO, Long sellerId) {
        Project project = modelMapper.map(projectDTO, Project.class);
        project.setSeller(sellerService.retrieveSellerById(sellerId));
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Long id, ProjectDTO projectDTO) {
        Project project =findProjectById(id);
        modelMapper.map(projectDTO, project);
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.delete(findProjectById(id));

    }

    private Bid findLowestBid(Set<Bid> project) {

        Bid lowestBid = project
                .stream()
                .min(Comparator.comparing(Bid::getPrice))
                .orElseThrow(NoSuchElementException::new);

        return lowestBid;
    }

    public Project findProjectById(Long id){
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    private Boolean isActive(Project project) {
        if(!project.getActive()){
            return false;
        }else{
           return checkProjectDeadline(project);
        }
    }

    private Boolean checkProjectDeadline(Project project) {
        if(project.getEndingDate().isBefore(LocalDateTime.now())){
            project.setActive(false);
            return false;
        }else{
            return true;
        }
    }
}

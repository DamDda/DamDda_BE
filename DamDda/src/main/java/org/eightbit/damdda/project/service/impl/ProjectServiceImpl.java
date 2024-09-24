package org.eightbit.damdda.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.eightbit.damdda.admin.domain.AdminApproval;
import org.eightbit.damdda.admin.dto.PageRequestDTO;
import org.eightbit.damdda.admin.dto.PageResponseDTO;
import org.eightbit.damdda.admin.dto.ProjectTitleDTO;
import org.eightbit.damdda.admin.repository.AdminApprovalRepository;
import org.eightbit.damdda.project.domain.Project;
import org.eightbit.damdda.project.domain.ProjectDocument;
import org.eightbit.damdda.project.domain.ProjectImage;
import org.eightbit.damdda.project.dto.ProjectDTO;
import org.eightbit.damdda.project.repository.ProjectDocumentRepository;
import org.eightbit.damdda.project.repository.ProjectImageRepository;
import org.eightbit.damdda.project.repository.ProjectRepository;
import org.eightbit.damdda.project.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final AdminApprovalRepository adminApprovalRepository;
    private final ModelMapper modelMapper;
    private final ProjectImageRepository projectImageRepository;
    private final ProjectDocumentRepository projectDocumentRepository;


    public Project registerProject(ProjectDTO projectDTO) {
        Project project = modelMapper.map(projectDTO, Project.class);
        Project result = projectRepository.save(project);
        AdminApproval adminApproval = AdminApproval.builder()
                .project(result)
                .approval(0)
                .build();
        adminApprovalRepository.save(adminApproval);
        return result;
    }

    @Override
    public ProjectDTO getProject(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        ProjectDTO projectDTO = modelMapper.map(project, ProjectDTO.class);
        projectDTO.setImages(projectImageRepository.findByProjectIdOrderByOrd(projectId));
        projectDTO.setDocuments(projectDocumentRepository.findByProjectIdOrderByOrd(projectId));
        return projectDTO;
    }

    @Override
    public PageResponseDTO<ProjectTitleDTO> findByApproval(PageRequestDTO pageRequestDTO) {
        Pageable pageable = PageRequest.of(pageRequestDTO.getPage(), pageRequestDTO.getSize(), Sort.by("id"));
        Page<ProjectTitleDTO> result = projectRepository.findByApproval(pageRequestDTO.getApproval(), pageable);
        PageResponseDTO<ProjectTitleDTO> response = PageResponseDTO.<ProjectTitleDTO>builder()
                .page(pageable.getPageNumber())
                .size(pageable.getPageSize())
                .totalPages(result.getTotalPages())
                .totalCounts(result.getNumberOfElements())
                .dtoList(result.getContent())
                .build();
        return response;
    }
}

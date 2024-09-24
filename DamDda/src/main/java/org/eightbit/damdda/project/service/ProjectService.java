package org.eightbit.damdda.project.service;


import org.eightbit.damdda.admin.dto.PageRequestDTO;
import org.eightbit.damdda.admin.dto.PageResponseDTO;
import org.eightbit.damdda.admin.dto.ProjectTitleDTO;
import org.eightbit.damdda.project.domain.Project;
import org.eightbit.damdda.project.dto.ProjectDTO;

public interface ProjectService {
    PageResponseDTO<ProjectTitleDTO> findByApproval(PageRequestDTO pageRequestDTO);
    Project registerProject(ProjectDTO projectDTO);
    ProjectDTO getProject(Long projectId);
}

package org.eightbit.damdda.admin.service;


import org.eightbit.damdda.admin.dto.ApprovalUpdateDTO;
import org.eightbit.damdda.admin.dto.PageRequestDTO;
import org.eightbit.damdda.admin.dto.PageResponseDTO;
import org.eightbit.damdda.admin.dto.ProjectTitleDTO;
import org.eightbit.damdda.member.dto.MemberDTO;
import org.eightbit.damdda.project.dto.ProjectDTO;

public interface AdminService {
    void updateApproval(ApprovalUpdateDTO approvalUpdateDTO);
    PageResponseDTO<ProjectTitleDTO> getProjectListByApproval(PageRequestDTO pageRequestDTO);
    ProjectDTO getProject(Long projectId);
    PageResponseDTO<MemberDTO> getMemberListByKeyword(PageRequestDTO pageRequestDTO);
}

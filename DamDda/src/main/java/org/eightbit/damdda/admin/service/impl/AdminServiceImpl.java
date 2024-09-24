package org.eightbit.damdda.admin.service.impl;


import lombok.RequiredArgsConstructor;

import org.eightbit.damdda.admin.domain.Admin;
import org.eightbit.damdda.admin.domain.AdminApproval;
import org.eightbit.damdda.admin.dto.ApprovalUpdateDTO;
import org.eightbit.damdda.admin.dto.PageRequestDTO;
import org.eightbit.damdda.admin.dto.PageResponseDTO;
import org.eightbit.damdda.admin.dto.ProjectTitleDTO;
import org.eightbit.damdda.admin.repository.AdminApprovalRepository;
import org.eightbit.damdda.admin.repository.AdminRepository;
import org.eightbit.damdda.admin.service.AdminService;
import org.eightbit.damdda.member.dto.MemberDTO;
import org.eightbit.damdda.member.service.MemberService;
import org.eightbit.damdda.project.domain.Project;
import org.eightbit.damdda.project.dto.ProjectDTO;
import org.eightbit.damdda.project.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final AdminApprovalRepository adminApprovalRepository;

    private final ProjectService projectService;
    private final MemberService memberService;

    @Override
    public PageResponseDTO<ProjectTitleDTO> getProjectListByApproval(PageRequestDTO pageRequestDTO) {
        return projectService.findByApproval(pageRequestDTO);
    }

    @Override
    public ProjectDTO getProject(Long projectId) {
        return projectService.getProject(projectId);
    }

    @Override
    public PageResponseDTO<MemberDTO> getMemberListByKeyword(PageRequestDTO pageRequestDTO) {
        return memberService.findByKeyword(pageRequestDTO);
    }

    @Override
    public void updateApproval(ApprovalUpdateDTO approvalUpdateDTO) {
        Optional<AdminApproval> result = adminApprovalRepository.findByProjectId(approvalUpdateDTO.getProjectId());
        if (result.isPresent()) {
            AdminApproval adminApproval = result.get();
            Admin admin = adminRepository.findByLoginId(approvalUpdateDTO.getAdminId()).orElseThrow();
            adminApproval.changeApproval(approvalUpdateDTO, admin);
            adminApprovalRepository.save(adminApproval);
        }
    }


}

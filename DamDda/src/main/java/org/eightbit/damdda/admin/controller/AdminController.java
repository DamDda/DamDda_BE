package org.eightbit.damdda.admin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.eightbit.damdda.admin.dto.*;
import org.eightbit.damdda.admin.service.AdminService;
import org.eightbit.damdda.common.service.JwtService;
import org.eightbit.damdda.member.dto.MemberDTO;
import org.eightbit.damdda.project.dto.ProjectDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    // 로그인 POST 요청
    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
        /*
         *  AuthenticationManager가 인증과정에서 사용하는 객체(Username~Token)에
         * 클라이언트가 전송한 username / password를 저장
         * */
        UsernamePasswordAuthenticationToken creds =
                new UsernamePasswordAuthenticationToken(
                        credentials.getLoginId(),
                        credentials.getPassword());
        /*
         * 아래 메소드가 호출되는 과정에서 UserDetailsServiceImpl에 override 한
         * loadUserByUsername이 호출되어 username을 가진 사용자가 DB에 존재하는지
         * 확인 후 내부적으로 로그인 처리함
         * */
        Authentication auth = authenticationManager.authenticate(creds);
        // Token 발급
        String jwts = jwtService.getToken(auth.getName());
        // 클라이언트에 전송할 AUTHORIZATION 헤더에 토큰을 넣어서 전달
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts)
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
                .build();
    }

    // 프로젝트 목록 요청(대기, 승인, 거절 별로)
    @GetMapping("/projects")
    public PageResponseDTO<ProjectTitleDTO> getList(PageRequestDTO pageRequestDTO) {
        PageResponseDTO<ProjectTitleDTO> pageResponseDTO = adminService.getProjectListByApproval(pageRequestDTO);
        return pageResponseDTO;
    }

    // 프로젝트 상세 요청
    @GetMapping("/projects/{projectId}")
    public ProjectDTO getProject(@PathVariable Long projectId) {
        log.info(adminService.getProject(projectId));
        return adminService.getProject(projectId);
    }

    // 프로젝트 승인/거절 처리
    @PutMapping("/projects/{projectId}")
    public void updateApproval(@PathVariable Long projectId, HttpServletRequest request,
                               @RequestBody ApprovalUpdateDTO approvalUpdateDTO) {
        String adminId = request.getAttribute("adminId").toString();
        approvalUpdateDTO.setAdminId(adminId);
        adminService.updateApproval(approvalUpdateDTO);
    }

    //회원 목록 요청(검색 기능 포함)
    @GetMapping("/members")
    public PageResponseDTO<MemberDTO> getUsers(PageRequestDTO pageRequestDTO) {
        return adminService.getMemberListByKeyword(pageRequestDTO);
    }
}

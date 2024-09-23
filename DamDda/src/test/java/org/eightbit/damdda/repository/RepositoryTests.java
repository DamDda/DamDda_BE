package org.eightbit.damdda.repository;

import lombok.extern.log4j.Log4j2;
import org.eightbit.damdda.admin.domain.Admin;
import org.eightbit.damdda.admin.domain.AdminApproval;
import org.eightbit.damdda.admin.dto.ApprovalUpdateDTO;
import org.eightbit.damdda.admin.dto.ProjectTitleDTO;
import org.eightbit.damdda.admin.repository.AdminApprovalRepository;
import org.eightbit.damdda.admin.repository.AdminRepository;
import org.eightbit.damdda.admin.service.AdminService;
import org.eightbit.damdda.admin.service.impl.AdminServiceImpl;
import org.eightbit.damdda.member.domain.Member;
import org.eightbit.damdda.member.repository.MemberRepository;
import org.eightbit.damdda.project.domain.Category;
import org.eightbit.damdda.project.domain.Project;
import org.eightbit.damdda.project.dto.ProjectDTO;
import org.eightbit.damdda.project.repository.CategoryRepository;
import org.eightbit.damdda.project.repository.ProjectRepository;
import org.eightbit.damdda.project.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class RepositoryTests {


    @Autowired
    private AdminRepository adminRepository;


    @Test
    public void insertAdmin() {
        BCryptPasswordEncoder cryptor = new BCryptPasswordEncoder();
        Admin admin = Admin.builder()
                .loginId("admin")
                .password(cryptor.encode("admin"))
                .build();
        adminRepository.save(admin);
    }


}

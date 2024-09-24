package org.eightbit.damdda.admin.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ApprovalUpdateDTO {
    private String adminId;
    private Long projectId;
    private Integer approval;
    private String approvalText;
}

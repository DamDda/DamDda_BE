package org.eightbit.damdda.project.domain;

import lombok.*;
import org.eightbit.damdda.common.domain.DateEntity;
import org.eightbit.damdda.member.domain.Member;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"tags", "category"})
public class Project extends DateEntity {

    @ManyToOne
    private Member member;
    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "project_tag",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id")
    )
    private List<Tag> tags;

    private String title;
    private String description;
    private String descriptionDetail;
    private Timestamp startDate;
    private Timestamp endDate;
    private Long targetFunding;
    private Long fundsReceive;
    private Long supporterCnt;
    private Long viewCnt;
    private Long likeCnt;
    private String thumbnailUrl;
    private Timestamp submitAt;
}

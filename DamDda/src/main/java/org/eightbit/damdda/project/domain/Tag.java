package org.eightbit.damdda.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.eightbit.damdda.common.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tags")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "projects")
public class Tag extends BaseEntity {
    private String name;
    private Integer usageFrequency;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Project> projects;

    // 필요하다면 명시적으로 setter를 추가할 수도 있습니다
    public void setUsageFrequency(Integer usageFrequency) {
        this.usageFrequency = usageFrequency;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

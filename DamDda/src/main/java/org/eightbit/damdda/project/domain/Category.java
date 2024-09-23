package org.eightbit.damdda.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "projects")
public class Category {


    @Id
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Project> projects;

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

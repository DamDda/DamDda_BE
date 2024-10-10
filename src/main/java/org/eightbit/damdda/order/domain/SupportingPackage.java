package org.eightbit.damdda.order.domain;

import lombok.*;
import org.eightbit.damdda.project.domain.ProjectPackage;

import javax.persistence.*;

@Entity
@Table(name = "supporting_packages")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class  SupportingPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;

    @ManyToOne
    @JoinColumn(name = "supporting_project_id")
    private SupportingProject supportingProject;

    private String packageName;
    private String packagePrice;
    private String packageCount;


}


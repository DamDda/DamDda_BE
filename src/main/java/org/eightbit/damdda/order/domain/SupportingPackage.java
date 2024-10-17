package org.eightbit.damdda.order.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.eightbit.damdda.project.domain.ProjectPackage;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "supporting_packages")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class  SupportingPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;
    @ManyToOne
    @JoinColumn(name="id")
    private ProjectPackage projectPackage;

    @ManyToOne
    @JoinColumn(name = "supporting_project_id")
    private SupportingProject supportingProject;
//
//    @ManyToMany(mappedBy = "supportingPackages")
//    private Set<Order> orders = new HashSet<>(); // 역방향 다대다 관계

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    //    private String packageName;
    //    private Long packagePrice;
    private Integer packageCount;

    //선택한 옵션
    @Column(columnDefinition = "json")
    private String OptionList;


}


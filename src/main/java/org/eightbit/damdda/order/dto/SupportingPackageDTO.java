package org.eightbit.damdda.order.dto;

// SupportingPackageDTO.java

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eightbit.damdda.project.dto.PackageDTO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupportingPackageDTO {
//    private Long projectPackageId;
//    private String packageName;
//    private Integer paymentPrice;

    private PackageDTO packageDTO;

    private Integer packageCount;
}
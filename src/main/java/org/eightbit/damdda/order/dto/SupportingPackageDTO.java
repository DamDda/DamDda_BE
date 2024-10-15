package org.eightbit.damdda.order.dto;

// SupportingPackageDTO.java

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupportingPackageDTO {
    private Long packageId;
    private String packageName;
    private Integer paymentPrice;
    private Integer packageCount;
}
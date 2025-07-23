package com.example.SalesManagementSystem.SMS.Dto.RequestDto.Refund;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public  class LineItemRequestDto {
    private Integer itemNo;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal discountRate;
    private BigDecimal taxRate;
    // The calculated fields (Tax, Total Price, Refund) are not included in the request DTO
}
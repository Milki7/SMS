package com.example.SalesManagementSystem.SMS.Dto.RequestDto.Voucher;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPriceDetailRequestDto {
    private Integer itemNo;
    private String itemCode;
    private String itemName;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal taxRate;
    private String amountInWord; // This might be provided by frontend or set by backend
    private String termsAndCondition;
    // No calculated fields here
}
package com.example.SalesManagementSystem.SMS.Dto.RequestDto.SalesItemPriceSetup;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesVoucherItemRequestDto {
    private UUID itemId;
    private String itemCode;
    private String itemName;
    private String uom;
    private String itemCategory;
    private Integer quantity;
    private BigDecimal unitPrice;
    private LocalDate expirationDate;
    private BigDecimal discountRate;
    private BigDecimal taxRate;
}
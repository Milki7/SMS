package com.example.SalesManagementSystem.SMS.Dto.RequestDto.DeliveryOrder;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineItemRequestDto {
    private Integer itemNo;
    private String itemName;
    private String itemCode;
    private String uom;
    private Integer quantity;
    private BigDecimal unitPrice;
}
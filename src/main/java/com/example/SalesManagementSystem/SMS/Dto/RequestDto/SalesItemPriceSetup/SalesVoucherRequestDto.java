package com.example.SalesManagementSystem.SMS.Dto.RequestDto.SalesItemPriceSetup;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesVoucherRequestDto {
    private String invoiceNo;
    private LocalDate salesDate;
    private Long customerId; // Provided by the client
    private String paymentType;
    private String paymentReference;
    private BigDecimal overallWithholdingRate; // Rate for overall withholding
    private String memoNote;
    private String preparedBy;

    private List<SalesVoucherItemRequestDto> lineItems;
}
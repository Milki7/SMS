package com.example.SalesManagementSystem.SMS.Dto.RequestDto.ServiceHandover;



// Remove enum imports here

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceHandoverRequestDto {
    private String customerName;
    private String mrc;
    private String reportedProblem;
    private String accessoriesBroughtWithMachine;
    private LocalDate startDate;
    private LocalDate endDate;
    private String telephone;
    private String contactPerson;
    private String receivedBy;
    private String modelNo;
    private String statusOfMachine;
    private String lastFsNumber;
    private String paymentType; // Now a String (valueCode)
    private BigDecimal paymentAmount;
    private String ercaRegion; // Now a String (valueCode)
    private String taxCenterRegion; // Now a String (valueCode)
}
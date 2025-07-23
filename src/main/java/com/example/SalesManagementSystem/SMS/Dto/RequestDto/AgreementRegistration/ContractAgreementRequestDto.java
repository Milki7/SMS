package com.example.SalesManagementSystem.SMS.Dto.RequestDto.AgreementRegistration;




import com.example.SalesManagementSystem.SMS.Enums.ContractAgreementStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ContractAgreementRequestDto {
    @NotNull(message = "Agreement Name is mandatory")
    private String agreementName;

    @NotNull(message = "Agreement Date is mandatory")
    @PastOrPresent(message = "Agreement Date cannot be in the future")
    private LocalDate agreementDate;

    @NotNull(message = "From Date is mandatory")
    private LocalDate fromDate;

    @NotNull(message = "To Date is mandatory")
    private LocalDate toDate;

    @NotNull(message = "Status is required")
    private Boolean activeStatus;


    @Size(max = 100, message = "Agreement document number cannot exceed 100 characters")
    private String agreementDocNo;

    @Size(max = 2000, message = "Description cannot exceed 2000 characters")
    private String description;

    byte[] documentContent;

    @NotNull(message = "Status is mandatory")
    private ContractAgreementStatus status;

    @NotNull(message = "Customer Name is mandatory")
    private String customerName;
}
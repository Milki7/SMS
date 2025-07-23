package com.example.SalesManagementSystem.SMS.Dto.RequestDto.AgreementRegistration;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInformationRequestDto{

    @NotBlank(message = "Full name is required")
    @Size(max = 255, message = "Full name cannot exceed 255 characters")
    private String fullName;

    @Size(max = 50, message = "House number cannot exceed 50 characters")
    private String houseNo;

    @Size(max = 1000, message = "Address cannot exceed 1000 characters")
    private String address;

    @Email(message = "Email should be valid")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    private String email;

    @Size(max = 50, message = "Telephone cannot exceed 50 characters")
    private String telephone;
}
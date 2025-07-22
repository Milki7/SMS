package com.example.SalesManagementSystem.SMS.model.AgreementRegistaration;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "witnesses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WitnessInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "tenant_id", nullable = false)
    private UUID tenantId;

    @NotBlank(message = "Full name is required")
    private String fullName;

    private String houseNo;

    @Email(message = "Invalid email format")
    private String email;

    private String telephone;


    @ManyToOne
    @JoinColumn(name = "contract_agreement_id", nullable = false) // A witness must be for a specific contract
    private ContractAgreementRegistration contractAgreement;


}
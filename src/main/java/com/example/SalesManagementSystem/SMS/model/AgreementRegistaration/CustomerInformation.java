package com.example.SalesManagementSystem.SMS.model.AgreementRegistaration;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Data
public class CustomerInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private UUID tenantId;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude // Prevent infinite loop
    private List<ContractAgreementRegistration> contractAgreements = new ArrayList<>() ;



}
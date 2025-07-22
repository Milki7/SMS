package com.example.SalesManagementSystem.SMS.model.AgreementRegistaration;



import com.example.SalesManagementSystem.SMS.Enums.ContractAgreementStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ContractAgreementRegistration")
public class ContractAgreementRegistration{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "tenant_id", nullable = false)
    private UUID tenantId;

    @NotBlank
    @Column(name = "Agreement_Name")
    private String agreementName;

    @NotNull
    @Column(name = "agreement_date", nullable = false)
    private LocalDate agreementDate; // Mandatory

    @NotNull
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate; // Mandatory

    @NotNull
    @Column(name = "to_date", nullable = false)
    private LocalDate toDate; // Mandatory

    @Column(name = "agreement_doc_no")
    private String agreementDocNo;

    @Column(name = "descriptions", columnDefinition = "TEXT")
    private String description;

    @Lob
    @Column
    private byte[] documentContent;

    @Enumerated(EnumType.STRING)
    @Column(name="status" , nullable = false)
    private ContractAgreementStatus status;

    @ManyToMany(mappedBy = "c")
    private List<ItemDetail> customerInformation= new ArrayList<>();

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDetail> itemDetail = new ArrayList<>();

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<WitnessInformation> witnesses = new ArrayList<>();
}
package com.example.SalesManagementSystem.SMS.model.Voucher;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "proforma_invoices")
public class ProformaInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;


    @Column(name = "tenant_id", nullable = false)
    private UUID tenantId;

    @Column(name = "proforma_no", unique = true, nullable = false, length = 50)
    private String proformaNo;

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "customer_name", length = 255)
    private String customerName;

    @Column(name = "customer_tin_no", length = 50)
    private String customerTinNo;

    @Column(name = "issued_date", nullable = false)
    private LocalDate issuedDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToMany(mappedBy = "proformaInvoice", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default // Lombok's way to ensure the list is initialized by default when using @Builder
    private List<ItemPriceDetail> lineItems = new ArrayList<>();


}
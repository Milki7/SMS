package com.example.SalesManagementSystem.SMS.model.ServiceHandover;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "service_handovers")
public class ServiceHandover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_name", length = 255, nullable = false)
    private String customerName;

    @Column(name = "customer_tin_no", length = 50)
    private String customerTinNo;

    @Column(name = "mrc", length = 100)
    private String mrc;

    @Column(name = "reported_problem", columnDefinition = "TEXT")
    private String reportedProblem;

    @Column(name = "accessories_brought_with_machine", columnDefinition = "TEXT")
    private String accessoriesBroughtWithMachine;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "telephone", length = 50)
    private String telephone;

    @Column(name = "contact_person", length = 100)
    private String contactPerson;

    @Column(name = "received_by", length = 100)
    private String receivedBy;

    @Column(name = "model_no", length = 100)
    private String modelNo;

    @Column(name = "status_of_machine", length = 100)
    private String statusOfMachine;

    @Column(name = "last_fs_number", length = 50)
    private String lastFsNumber;

    // These now store the String 'valueCode' from the LookupValue entity
    @Column(name = "payment_type", length = 50)
    private String paymentType;

    @Column(name = "payment_amount", precision = 10, scale = 2)
    private BigDecimal paymentAmount;

    @Column(name = "erca_region", length = 100)
    private String ercaRegion;

    @Column(name = "tax_center_region", length = 100)
    private String taxCenterRegion;
}
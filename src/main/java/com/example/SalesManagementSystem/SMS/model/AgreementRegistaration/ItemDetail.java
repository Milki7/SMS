package com.example.SalesManagementSystem.SMS.model.AgreementRegistaration;



import com.example.SalesManagementSystem.SMS.model.LookUp.PaymentMethodLookup;
import com.example.SalesManagementSystem.SMS.model.LookUp.PrePaymenentPercepentLookup;
import com.example.SalesManagementSystem.SMS.model.LookUp.ServiceCenterLookup;
import com.example.SalesManagementSystem.SMS.model.LookUp.TaxCenterLookup;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "item_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private UUID tenantId;

    @NotBlank
    private UUID itemId;

    @NotNull
    private Double quantity;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "service_center_id")
    public ServiceCenterLookup serviceCenter;;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "tax_center_id")
    private TaxCenterLookup taxCenter;



    private BigDecimal unitPrice ;

    private BigDecimal subTotal ;
    private BigDecimal tax ;
    private BigDecimal grandTotal;

    private String amountInWords;
    private String memoOrNote;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethodLookup paymentMethod;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pre_payment_percent_id")
    private PrePaymenentPercepentLookup prePaymentPercent;


    private String paymentReference;
    private BigDecimal prePaymentAmount ;
    private BigDecimal remainingAmount ;

    @ManyToOne
    @JoinColumn(name = "contract_agreement_id", nullable = false) // Assuming an ItemServiceDetail must belong to a Contract
    private ContractAgreementRegistration contractAgreement;

}


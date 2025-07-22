package com.example.SalesManagementSystem.SMS.model.SalesItemPriceSetup;





import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "sales_vouchers")
public class SalesVoucher {

    @Id // Invoice No. seems to be the unique identifier for a sales voucher
    @Column(name = "invoice_no", unique = true, nullable = false, length = 50)
    private UUID id;

    private UUID tenantId;

    private UUID invoiceNo;

    @Column(name = "sales_date", nullable = false)
    private LocalDate salesDate;

    // Fields retrieved from the Customer Service
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "customer_name", length = 255)
    private String customerName;

    @Column(name = "customer_tin_no", length = 50)
    private String customerTinNo;

    @Column(name = "payment_type", length = 50) // E.g., "Cash", "Credit", "Card"
    private PaymentType paymentType;

    @Column(name = "payment_reference", length = 100) // E.g., transaction ID, check number
    private String paymentReference;

    // "Withholding" from the top right part of the form, likely a rate/percentage
    // (This is distinct from the per-line-item discount)
    @Column(name = "overall_withholding_rate", precision = 5, scale = 2) // e.g., 0.02 for 2%
    private Withholdings withholding ;

    // These fields will be derived/calculated, not directly stored on the entity if they are sums
    // private BigDecimal subTotal;
    // private BigDecimal withholdingAmount; // Calculated: grandTotal * overallWithholdingRate
    // private BigDecimal vatAmount; // Calculated from line items
    // private BigDecimal overallDiscountAmount; // Calculated from line items
    // private BigDecimal grandTotal; // Calculated

    @Column(name = "amount_in_word", length = 500)
    private String amountInWord; // Calculated based on Grand Total

    @Column(name = "memo_note", columnDefinition = "TEXT")
    private String memoNote;

    @Column(name = "prepared_by", length = 100)
    private String preparedBy;

    // --- Relationship with SalesVoucherLineItem ---
    @OneToMany(mappedBy = "salesVoucher", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<SalesVoucherItemPrice> lineItems = new ArrayList<>();

    // Helper methods to manage the bidirectional relationship
    public void addLineItem(SalesVoucherItemPrice lineItem) {
        lineItems.add(lineItem);
        lineItem.setSalesVoucher(this);
    }

    public void removeLineItem(SalesVoucherItemPrice lineItem) {
        lineItems.remove(lineItem);
        lineItem.setSalesVoucher(null);
    }
}
package com.example.SalesManagementSystem.SMS.model.Refund;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "refund_books")
public class RefundBook {

    @Id //
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private UUID tenantId;

    @Column(name = "ref_no", unique = true, nullable = false, length = 50)
    private String refNo;

    @Column(name = "refund_date", nullable = false)
    private LocalDate refundDate;

    @Column(name = "refund_reason", columnDefinition = "TEXT")
    private String refundReason;

    // Reference to the original Invoice (from Sales Voucher)
    @Column(name = "invoice_no", nullable = false, length = 50)
    private String invoiceNo;

    // Customer Name and TIN No. are typically pulled from the linked Invoice or Customer Service
    // We'll store them here for denormalization/convenience
    @Column(name = "customer_name", length = 255)
    private String customerName;

    @Column(name = "customer_tin_no", length = 50)
    private String customerTinNo;

    // Calculated totals (will be derived from line items)
    // We store them here for easy retrieval and persistence of the calculated snapshot.
    @Column(name = "sub_total", precision = 10, scale = 2)
    private BigDecimal subTotal;

    @Column(name = "overall_withholding_amount", precision = 10, scale = 2)
    private BigDecimal overallWithholdingAmount;

    @Column(name = "vat_amount", precision = 10, scale = 2)
    private BigDecimal vatAmount;

    @Column(name = "overall_discount_amount", precision = 10, scale = 2)
    private BigDecimal overallDiscountAmount;

    @Column(name = "grand_total", precision = 10, scale = 2)
    private BigDecimal grandTotal;

    // "Refund" is listed as a total in the screenshot, implying it might be a final refund amount.
    // It could be Grand Total or a specific negotiated amount.
    // Assuming it's the Grand Total that will be refunded.
    @Column(name = "final_refund_amount", precision = 10, scale = 2)
    private BigDecimal finalRefundAmount;

    @Column(name = "prepared_by", length = 100) // Assuming this field exists based on other forms
    private String preparedBy;

    // --- Relationship with RefundBookLineItem ---
    @OneToMany(mappedBy = "refundBook", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<RefundBookLineItem> lineItems = new ArrayList<>();

    // Helper methods for bidirectional relationship
    public void addLineItem(RefundBookLineItem lineItem) {
        lineItems.add(lineItem);
        lineItem.setRefundBook(this);
    }

    public void removeLineItem(RefundBookLineItem lineItem) {
        lineItems.remove(lineItem);
        lineItem.setRefundBook(null);
    }
}
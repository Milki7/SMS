package com.example.SalesManagementSystem.SMS.model.Refund;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "refund_book_line_items")
public class RefundBookLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Primary key for the line item itself

    @Column(name = "item_no", nullable = false)
    private Integer itemNo; // "No." column from the screenshot

    @Column(name = "quantity", nullable = false)
    private Integer quantity; // Quantity being refunded

    @Column(name = "unit_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "discount_rate", precision = 5, scale = 2) // Discount rate applied on this item during refund
    private BigDecimal discountRate;

    @Column(name = "item_discount_amount", precision = 10, scale = 2)
    private BigDecimal itemDiscountAmount; // Calculated: quantity * unitPrice * discountRate

    @Column(name = "tax_rate", precision = 5, scale = 2) // Tax rate for this item during refund
    private BigDecimal taxRate;

    @Column(name = "item_tax_amount", precision = 10, scale = 2)
    private BigDecimal itemTaxAmount; // Calculated: (quantity * unitPrice - itemDiscountAmount) * taxRate

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice; // Calculated: (quantity * unitPrice - itemDiscountAmount) + itemTaxAmount

    // "Refund" from the line item row; this implies the amount being refunded for that specific item.
    // It's often equal to totalPrice, but could be less if only a partial refund is given.
    @Column(name = "line_item_refund_amount", precision = 10, scale = 2)
    private BigDecimal lineItemRefundAmount;

    // --- Relationship with RefundBook ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_no", referencedColumnName = "ref_no", nullable = false)
    private RefundBook refundBook;

    // Helper method for calculation
    public void calculateTotals() {
        if (quantity != null && unitPrice != null) {
            BigDecimal subtotalPerItem = unitPrice.multiply(new BigDecimal(quantity));

            this.itemDiscountAmount = BigDecimal.ZERO;
            if (discountRate != null) {
                this.itemDiscountAmount = subtotalPerItem.multiply(discountRate).setScale(2, RoundingMode.HALF_UP);
            }

            BigDecimal taxableAmount = subtotalPerItem.subtract(this.itemDiscountAmount);

            this.itemTaxAmount = BigDecimal.ZERO;
            if (taxRate != null) {
                this.itemTaxAmount = taxableAmount.multiply(taxRate).setScale(2, RoundingMode.HALF_UP);
            }

            this.totalPrice = taxableAmount.add(this.itemTaxAmount).setScale(2, RoundingMode.HALF_UP);
            this.lineItemRefundAmount = this.totalPrice; // Default to full refund for the item
        } else {
            this.itemDiscountAmount = BigDecimal.ZERO;
            this.itemTaxAmount = BigDecimal.ZERO;
            this.totalPrice = BigDecimal.ZERO;
            this.lineItemRefundAmount = BigDecimal.ZERO;
        }
    }
}
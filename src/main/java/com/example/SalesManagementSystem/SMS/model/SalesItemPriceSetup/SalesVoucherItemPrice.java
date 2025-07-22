package com.example.SalesManagementSystem.SMS.model.SalesItemPriceSetup;


import com.example.SalesTransactionService.SalesTransaction.models.Lookups.Discount;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sales_voucher_line_items")
public class SalesVoucherItemPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id; // Primary key for the line item itself

    @Column(name = "item_no", nullable = false)
    private UUID itemId ; // "

    @Column(name = "item_code", length = 50, nullable = false)
    private String itemCode;

    @Column(name = "item_name", length = 255, nullable = false)
    private String itemName;

    @Column(name = "uom", length = 20) // Unit of Measure (e.g., "pcs", "kg")
    private String uom;

    @Column(name = "item_category", length = 50)
    private String itemCategory;

    @Column(name = "quantity", nullable = false)
    private Integer quantity; // Or BigDecimal if fractional quantities

    @Column(name = "unit_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "expiration_date") // Optional: only if applicable to items
    private LocalDate expirationDate;

    @Column(name = "discount_rate", precision = 5, scale = 2) // Percentage e.g., 0.10 for 10%
    private Discount discountRate;

    // Calculated fields, often stored for snapshot consistency
    @Column(name = "item_discount_amount", precision = 10, scale = 2)
    private BigDecimal itemDiscountAmount; // Calculated: quantity * unitPrice * discountRate

    @Column(name = "tax_rate", precision = 5, scale = 2) // VAT/Sales Tax rate
    private BigDecimal taxRate;

    @Column(name = "item_tax_amount", precision = 10, scale = 2)
    private BigDecimal itemTaxAmount; // Calculated: (quantity * unitPrice - itemDiscountAmount) * taxRate

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice; // Calculated: (quantity * unitPrice - itemDiscountAmount) + itemTaxAmount

    // --- Relationship with SalesVoucher ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_no", referencedColumnName = "invoice_no", nullable = false)
    private SalesVoucher salesVoucher;

    // Helper methods for calculation (executed in service layer before persist)
    public void calculateTotals() {
        if (quantity != null && unitPrice != null) {
            BigDecimal lineSubtotal = unitPrice.multiply(new BigDecimal(quantity));

            this.itemDiscountAmount = BigDecimal.ZERO;
            if (discountRate != null) {
                this.itemDiscountAmount = lineSubtotal.multiply(discountRate);
            }

            BigDecimal taxableAmount = lineSubtotal.subtract(this.itemDiscountAmount);

            this.itemTaxAmount = BigDecimal.ZERO;
            if (taxRate != null) {
                this.itemTaxAmount = taxableAmount.multiply(taxRate);
            }

            this.totalPrice = taxableAmount.add(this.itemTaxAmount);
        } else {
            this.itemDiscountAmount = BigDecimal.ZERO;
            this.itemTaxAmount = BigDecimal.ZERO;
            this.totalPrice = BigDecimal.ZERO;
        }
    }
}
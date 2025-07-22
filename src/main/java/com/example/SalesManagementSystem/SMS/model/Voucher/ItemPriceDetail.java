package com.example.SalesManagementSystem.SMS.model.Voucher;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item_price_detail")
public class   ItemPriceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "tenant_id", nullable = false)
    private UUID tenantId;

    @Column(name = "item_id")
    private UUID itemId;

    @Column(name = "item_code")
    private String itemCode;
    @Column(name = "uom")
    private String uom;


    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "unit_price", precision = 10, scale = 2, nullable = false) // Precision for monetary values
    private BigDecimal unitPrice;

    @Column(name = "tax_rate", precision = 5, scale = 2, nullable = false) // e.g., 0.15 for 15%
    private BigDecimal taxRate;

    // Derived fields, but often stored for snapshot consistency
    @Column(name = "item_tax_amount", precision = 10, scale = 2)
    private BigDecimal itemTaxAmount; // Calculated: quantity * unitPrice * taxRate

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice; // Calculated: (quantity * unitPrice) + itemTaxAmount

    @Column(name = "amount_in_word", length = 500) // Adjust length as needed
    private String amountInWord;

    @Column(name = "terms_and_condition", columnDefinition = "TEXT") // Use TEXT for potentially long strings
    private String termsAndCondition;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proforma_no", referencedColumnName = "proforma_no", nullable = false)
    // 'proforma_no' is the foreign key column in this table, referencing 'proforma_no' in ProformaInvoice
    private ProformaInvoice proformaInvoice;
    public void calculateTotals() {
        if (quantity != null && unitPrice != null && taxRate != null) {
            BigDecimal subtotalPerItem = unitPrice.multiply(new BigDecimal(quantity));
            this.itemTaxAmount = subtotalPerItem.multiply(taxRate);
            this.totalPrice = subtotalPerItem.add(this.itemTaxAmount);
        } else {
            this.itemTaxAmount = BigDecimal.ZERO;
            this.totalPrice = BigDecimal.ZERO;
        }
    }
}
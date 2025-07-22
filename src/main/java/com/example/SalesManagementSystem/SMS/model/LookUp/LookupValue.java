package com.example.SalesManagementSystem.SMS.model.LookUp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "lookup_values", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"lookup_type_code", "value_code"})
})
public class LookupValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lookup_type_code", referencedColumnName = "type_code", nullable = false)
    private LookupType lookupType;

    @Column(name = "value_code", nullable = false, length = 50)
    private String valueCode; // e.g., "CASH", "ADDIS_ABABA"

    @Column(name = "display_name", nullable = false, length = 100)
    private String displayName; // e.g., "Cash", "Addis Ababa"

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "is_active")
    private Boolean isActive = true;
}
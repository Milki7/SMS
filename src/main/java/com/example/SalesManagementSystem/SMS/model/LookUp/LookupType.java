package com.example.SalesManagementSystem.SMS.model.LookUp;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "lookup_types")
public class LookupType {

    @Id
    @Column(name = "type_code", unique = true, nullable = false, length = 50)
    private String typeCode; // e.g., "PAYMENT_TYPE", "ERCA_REGION"

    @Column(name = "type_name", nullable = false, length = 100)
    private String typeName; // e.g., "Payment Types", "ERCA Regions"

    @Column(name = "description", length = 255)
    private String description;

    @OneToMany(mappedBy = "lookupType", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<LookupValue> values = new ArrayList<>();

    public void addValue(LookupValue value) {
        values.add(value);
        value.setLookupType(this);
    }

    public void removeValue(LookupValue value) {
        values.remove(value);
        value.setLookupType(null);
    }
}
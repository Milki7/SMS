package com.example.SalesManagementSystem.SMS.model.LookUp;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaxCenterLookup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private UUID id;
    private String name;
}
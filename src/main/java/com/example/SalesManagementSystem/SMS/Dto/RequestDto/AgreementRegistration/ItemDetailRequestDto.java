package com.example.SalesManagementSystem.SMS.Dto.RequestDto.AgreementRegistration;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDetailRequestDto {

    private UUID id; // Include ID for updates (to identify which item to modify)

    @NotBlank(message = "Item name is required")
    @Size(max = 255, message = "Item name cannot exceed 255 characters")
    private String itemName;

    @Size(max = 50, message = "UOM cannot exceed 50 characters")
    private String uom;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    private LocalDate expirationDate;


    private Long serviceCenterId;
    private Long taxCenterRegionId;

    @Size(max = 100, message = "Item category cannot exceed 100 characters")
    private String itemCategory;

    @Size(max = 100, message = "Item code cannot exceed 100 characters")
    private String itemCode;

    // Use Double or String if not BigDecimal in entity
    @NotNull(message = "Unit price is required")
    @Min(value = 0, message = "Unit price cannot be negative")
    private Double unitPrice;

    @Size(max = 255, message = "Brand model cannot exceed 255 characters")
    private String brandModel;

    @Size(max = 50, message = "MRIC cannot exceed 50 characters")
    private String mric;
}
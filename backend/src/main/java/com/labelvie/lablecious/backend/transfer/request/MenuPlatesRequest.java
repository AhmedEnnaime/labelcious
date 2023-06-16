package com.labelvie.lablecious.backend.transfer.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class MenuPlatesRequest {
    private long id;
    @NotBlank(message = "PlateId is required")
    private Long plateId;

    @NotBlank(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be greater than 0")
    private int quantity;
}

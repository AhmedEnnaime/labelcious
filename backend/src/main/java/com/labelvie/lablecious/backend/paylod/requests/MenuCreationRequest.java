package com.labelvie.lablecious.backend.paylod.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuCreationRequest {
    private Date date;
    private List<PlateQuantity> plates;

    // Getters and setters

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PlateQuantity {
        private Long plateId;
        private Integer quantity;

        // Getters and setters
    }
}

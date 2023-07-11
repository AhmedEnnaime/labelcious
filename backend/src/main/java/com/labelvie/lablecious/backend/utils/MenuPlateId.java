package com.labelvie.lablecious.backend.utils;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuPlateId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long menuId;

    private Long plateId;
}

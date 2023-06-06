package com.labelvie.lablecious.backend.services;

import com.labelvie.lablecious.backend.models.dto.PlateDto;
import com.labelvie.lablecious.backend.models.entity.Plate;

import java.util.List;

public interface PlateService {
    List<PlateDto> getAllPlates();
    PlateDto getPlateById(long id);
}

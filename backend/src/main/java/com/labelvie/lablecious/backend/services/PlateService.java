package com.labelvie.lablecious.backend.services;

import com.labelvie.lablecious.backend.models.dto.PlateDto;
import com.labelvie.lablecious.backend.models.entity.Plate;

import java.util.List;

public interface PlateService {
    List<PlateDto> getPlates();
    PlateDto getPlateById(long id);
    PlateDto savePlate(PlateDto plateDto);
    PlateDto updatePlate(long id, PlateDto plateDto);
    void deletePlate(long id);

    Plate findOrFail(long id);
    List<PlateDto>  getPlatesByCategoryId(long id);
}

package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.dto.PlateDto;
import com.labelvie.lablecious.backend.models.entity.Plate;
import com.labelvie.lablecious.backend.repository.PlateRepository;
import com.labelvie.lablecious.backend.services.CategoryService;
import com.labelvie.lablecious.backend.services.PlateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PlateServiceImpl implements PlateService {

    private  final PlateRepository plateRepository;
    private final CategoryService categoryService;

    @Override
    public List<PlateDto> getPlates() {
        return PlateDto.fromPlates(plateRepository.findAll());
    }

    @Override
    public PlateDto getPlateById(long id) {
        return PlateDto.fromPlate(this.findOrFail(id));
    }

    @Override
    public PlateDto savePlate(PlateDto plateDto) {
        Plate plate = plateDto.toPlate();
        plate.setCategory(categoryService.findOrFail(plateDto.getCategoryId()));
        return PlateDto.fromPlate(plateRepository.save(plate));
    }

    @Override
    public PlateDto updatePlate(long id, PlateDto plateDto) {
        plateDto.setId(this.findOrFail(id).getId());
        Plate plate = plateDto.toPlate();
        plate.setCategory(categoryService.findOrFail(plateDto.getCategoryId()));
        return PlateDto.fromPlate(plateRepository.save(plate));
    }

    @Override
    public void deletePlate(long id) {
        plateRepository.delete(this.findOrFail(id));
    }

    @Override
    public Plate findOrFail(long id) {
        return plateRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("The plate with id " + id + " does not exist"));
    }
}

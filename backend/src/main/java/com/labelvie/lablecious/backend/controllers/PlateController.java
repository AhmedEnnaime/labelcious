package com.labelvie.lablecious.backend.controllers;

import com.labelvie.lablecious.backend.models.dto.PlateDto;
import com.labelvie.lablecious.backend.services.PlateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/plates")
@AllArgsConstructor
public class PlateController {

    private final PlateService plateService;

    @GetMapping
    public ResponseEntity<List<PlateDto>> getPlates() {
        List<PlateDto> plates = plateService.getPlates();
        return ResponseEntity.ok(plates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlateDto> getPlateById(@PathVariable long id) {
        PlateDto plate = plateService.getPlateById(id);
        return ResponseEntity.ok(plate);
    }

    @PostMapping
    public ResponseEntity<PlateDto> createPlate(  @RequestBody PlateDto plateDto) {
        PlateDto createdPlate = plateService.savePlate(plateDto);
        return ResponseEntity.ok(createdPlate);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PlateDto> updatePlate(@PathVariable long id, @RequestBody PlateDto plateDto) {
        PlateDto updatedPlate = plateService.updatePlate(id, plateDto);
        return ResponseEntity.ok(updatedPlate);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlate(@PathVariable long id) {
        plateService.deletePlate(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/category/{id}")
    public ResponseEntity<List<PlateDto>> getPlatesByCategoryId(@PathVariable long id) {
        List<PlateDto> plates = plateService.getPlatesByCategoryId(id);
        return ResponseEntity.ok(plates);
    }

}


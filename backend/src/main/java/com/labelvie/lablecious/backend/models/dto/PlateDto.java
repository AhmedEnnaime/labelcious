package com.labelvie.lablecious.backend.models.dto;


import com.labelvie.lablecious.backend.models.entity.Plate;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;


@Data
public class PlateDto {
    private  long id;
    private String name;
    private String description;
    private String image;

    public  static  PlateDto fromPlate(Plate plate){
        PlateDto plateDto = new PlateDto();
        plateDto.setId(plate.getId());
        plateDto.setName(plate.getName());
        plateDto.setDescription(plate.getDescription());
        plateDto.setImage(plate.getImage());
        return plateDto;
    }

    public  static List<PlateDto> fromPlates(List<Plate> plates){
        return plates.stream()
                .map(PlateDto::fromPlate)
                .collect(Collectors.toList());
    }


}

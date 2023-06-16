package com.labelvie.lablecious.backend.models.dto;

import com.labelvie.lablecious.backend.models.entity.MenuPlates;
import com.labelvie.lablecious.backend.transfer.request.MenuPlatesRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class MenuPlateDto {
    private long id;
    private int quantity;
    private PlateDto plate;
    private MenuDto menu;

    public static MenuPlateDto fromRequest(MenuDto menuDto, MenuPlatesRequest menuPlatesRequest) {
        return MenuPlateDto.builder()
                .id(menuPlatesRequest.getId())
                .quantity(menuPlatesRequest.getQuantity())
                .plate(PlateDto.builder().id(menuPlatesRequest.getPlateId()).build())
                .menu(MenuDto.builder().id(menuDto.getId()).build())
                .build();
    }

    public static List<MenuPlateDto> fromRequestList(MenuDto menuDto, List<MenuPlatesRequest> menuPlatesRequest) {
        return menuPlatesRequest.stream()
                .map(menuPlateRequest -> MenuPlateDto.fromRequest(menuDto, menuPlateRequest))
                .collect(java.util.stream.Collectors.toList());

    }

    public MenuPlates toEntity() {
        return MenuPlates.builder()
                .id(this.getId())
                .quantity(this.getQuantity())
                .plate(this.getPlate().toEntity())
                .menu(this.getMenu().toEntity())
                .build();
    }

    public static List<MenuPlates> toEntityList(List<MenuPlateDto> menuPlateDto) {
        return menuPlateDto.stream()
                .map(MenuPlateDto::toEntity)
                .collect(java.util.stream.Collectors.toList());
    }
}

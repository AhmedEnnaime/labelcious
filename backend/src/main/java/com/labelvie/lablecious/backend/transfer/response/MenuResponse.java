package com.labelvie.lablecious.backend.transfer.response;

import com.labelvie.lablecious.backend.models.entity.Menu;
import com.labelvie.lablecious.backend.models.entity.MenuPlates;
import com.labelvie.lablecious.backend.models.entity.Plate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuResponse {
    private long id;
    private String date;
    private List<Plates> plates;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Plates {
        private Plate plate;
        private int quantity;
    }

    public static MenuResponse fromMenu(Menu menu) {
        return MenuResponse.builder()
                .id(menu.getId())
                .date(menu.getDate())
                .build();
    }

    public static MenuResponse fromMenu(Menu menu, List<Plates> platesList) {
        return MenuResponse.builder()
                .id(menu.getId())
                .date(menu.getDate())
                .plates(platesList)
                .build();

    }

    public static List<MenuResponse> fromMenus(List<Menu> menus) {
        return menus.stream()
                .map(MenuResponse::fromMenu)
                .collect(Collectors.toList());
    }

    public Menu toMenu() {
        return Menu.builder()
                .id(this.getId())
                .date(this.getDate())
                .build();
    }

    public static MenuResponse fromMenuPlatesList(List<MenuPlates> menuPlatesList) {
        List<Plates> platesList = menuPlatesList.stream()
                .map(menuPlates -> Plates.builder()
                        .plate(menuPlates.getPlate())
                        .quantity(menuPlates.getQuantity())
                        .build())
                .collect(Collectors.toList());

        return MenuResponse.builder()
                .id(menuPlatesList.get(0).getMenu().getId())
                .date(menuPlatesList.get(0).getMenu().getDate())
                .plates(platesList)
                .build();
    }

    public static  List<Plates> fromMenuPlatesListToPlatesList(List<MenuPlates> menuPlatesList) {
        return menuPlatesList.stream()
                .map(menuPlates -> Plates.builder()
                        .plate(menuPlates.getPlate())
                        .quantity(menuPlates.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }

}

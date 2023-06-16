package com.labelvie.lablecious.backend.models.dto;

import com.labelvie.lablecious.backend.models.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Builder
@Data
public class MenuDto {
    private long id;
    private Date date;

    public  static MenuDto fromEntity(Menu menu){
        return MenuDto.builder()
            .id(menu.getId())
            .date(menu.getDate())
            .build();
    }

    public static List<MenuDto> fromEntity(List<Menu> menus){
        return menus.stream().map(MenuDto::fromEntity).collect(Collectors.toList());
    }

    public Menu toEntity(){
        return Menu.builder()
            .id(this.getId())
            .date(this.getDate())
            .build();
    }
}

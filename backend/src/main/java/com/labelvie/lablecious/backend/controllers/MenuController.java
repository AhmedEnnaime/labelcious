package com.labelvie.lablecious.backend.controllers;

import com.labelvie.lablecious.backend.models.entity.Menu;
import com.labelvie.lablecious.backend.paylod.requests.MenuCreationRequest;
import com.labelvie.lablecious.backend.services.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<Menu> saveMenu(@RequestBody Menu menu) {
        return  new ResponseEntity<Menu>(menuService.saveMenu(menu), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Menu> getMenus() {
        return menuService.getMenus();
    }

    @PostMapping("/createWithPlates")
    public ResponseEntity<Menu> createMenuWithPlates(
            @RequestBody MenuCreationRequest request) {

        Menu menu = new Menu();
        menu.setDate(request.getDate());

        Map<Long, Integer> plateQuantityMap = new HashMap<>();
        for (MenuCreationRequest.PlateQuantity plateQuantity : request.getPlates()) {
            plateQuantityMap.put(plateQuantity.getPlateId(), plateQuantity.getQuantity());
        }

        Menu createdMenu = menuService.createMenuWithPlates(menu, plateQuantityMap);
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
    }

}

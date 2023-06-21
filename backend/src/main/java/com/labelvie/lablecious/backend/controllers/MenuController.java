package com.labelvie.lablecious.backend.controllers;


import com.labelvie.lablecious.backend.services.MenuService;
import com.labelvie.lablecious.backend.transfer.request.MenuRequest;
import com.labelvie.lablecious.backend.transfer.response.MenuResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/menus")
@AllArgsConstructor
public class MenuController {

    private  final MenuService menuService;
//    private  final  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping
    public ResponseEntity<List<MenuResponse>> getMenus() {
        List<MenuResponse> menus = menuService.getMenus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuResponse> getMenuById(@PathVariable long id) {
        MenuResponse menu = menuService.getMenuById(id);
        return ResponseEntity.ok(menu);
    }
    @GetMapping("/date/{date}")
    public ResponseEntity<List<MenuResponse>> getMenuByDate(@PathVariable("date") String dateString) throws ParseException {
//         return ResponseEntity.ok(menuService.getMenuByDate(dateFormat.parse(dateString)));
        return ResponseEntity.ok(menuService.getMenuByDate(dateString));
    }

    @PostMapping
    public ResponseEntity<MenuResponse> createMenu(@RequestBody MenuRequest menu) {
        return ResponseEntity.ok(menuService.saveMenu(menu));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuResponse> updateMenu(@PathVariable long id, @RequestBody MenuRequest menu) {
        return ResponseEntity.ok(menuService.updateMenu(id, menu));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MenuResponse> deleteMenuById(@PathVariable long id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }

}

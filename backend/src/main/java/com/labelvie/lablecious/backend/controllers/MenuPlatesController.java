package com.labelvie.lablecious.backend.controllers;


import com.labelvie.lablecious.backend.models.entity.MenuPlates;
import com.labelvie.lablecious.backend.services.MenuPlatesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/menuPlates")
@AllArgsConstructor
public class MenuPlatesController {

    private  final MenuPlatesService menuPlatesService;

    @GetMapping
    public ResponseEntity<List<MenuPlates>> getMenuPlates() {
        List<MenuPlates> menuPlates = menuPlatesService.findAll();
        return ResponseEntity.ok(menuPlates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuPlates> getMenuPlatesById(@PathVariable long id) {
        MenuPlates menuPlates = menuPlatesService.findById(id);
        return ResponseEntity.ok(menuPlates);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MenuPlates> deleteMenuPlatesById(@PathVariable long id) {
        menuPlatesService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<MenuPlates> createMenuPlates(@RequestBody MenuPlates menuPlates) {
        return ResponseEntity.ok(menuPlatesService.save(menuPlates));
    }

    @PostMapping("/all")
    public ResponseEntity<List<MenuPlates>> createMenuPlates(@RequestBody List<MenuPlates> menuPlates) {
        return ResponseEntity.ok(menuPlatesService.saveAll(menuPlates));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuPlates> updateMenuPlates(@PathVariable long id, @RequestBody MenuPlates menuPlates) {
        MenuPlates updatedMenuPlates = menuPlatesService.update(id, menuPlates);
        return ResponseEntity.ok(updatedMenuPlates);
    }

}

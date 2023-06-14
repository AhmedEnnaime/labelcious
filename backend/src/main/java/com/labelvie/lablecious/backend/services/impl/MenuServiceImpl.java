package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.entity.Menu;
import com.labelvie.lablecious.backend.models.entity.MenuPlate;
import com.labelvie.lablecious.backend.models.entity.Plate;
import com.labelvie.lablecious.backend.repository.MenuRepository;
import com.labelvie.lablecious.backend.repository.PlateRepository;
import com.labelvie.lablecious.backend.services.MenuService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final PlateRepository plateRepository;

    public MenuServiceImpl(MenuRepository menuRepository, PlateRepository plateRepository) {
        this.menuRepository = menuRepository;
        this.plateRepository = plateRepository;
    }

    @Override
    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu createMenuWithPlates(Menu menu, Map<Long, Integer> plateQuantityMap) {
        Menu createdMenu = menuRepository.save(menu);

        Set<MenuPlate> menuPlates = new HashSet<>();
        for (Map.Entry<Long, Integer> entry : plateQuantityMap.entrySet()) {
            long plateId = entry.getKey();
            int quantity = entry.getValue();
            Plate plate = plateRepository.findById(plateId)
                    .orElseThrow(() -> new ResourceNotFoundException("The plate with id " + plateId + " does not exist"));

            MenuPlate menuPlate = new MenuPlate(createdMenu, plate);
            menuPlate.setQuantity(quantity);

            menuPlates.add(menuPlate);
        }

        createdMenu.setMenuPlates(menuPlates);
        menuRepository.save(createdMenu);

        return createdMenu;
    }



}

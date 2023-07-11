package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.dto.MenuDto;
import com.labelvie.lablecious.backend.models.dto.MenuPlateDto;
import com.labelvie.lablecious.backend.models.entity.Menu;
import com.labelvie.lablecious.backend.models.entity.MenuPlates;
import com.labelvie.lablecious.backend.repository.MenuRepository;
import com.labelvie.lablecious.backend.services.MenuService;
import com.labelvie.lablecious.backend.transfer.request.MenuRequest;
import com.labelvie.lablecious.backend.transfer.response.MenuResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {

    private  final MenuRepository menuRepository;
    private final PlateServiceImpl plateService;
    private final MenuPlatesServiceImpl menuPlatesService;


    private List<MenuPlates>  menuPlatesList , menuPlatesListSaved;
    private Menu menu;
    private List<Menu> menuList;
    private List<MenuResponse.Plates> platesList;
    private MenuPlates menuPlate;


    @Override
    public List<MenuResponse> getMenus() {
        menuList = menuRepository.findAll();
        return menuList.stream().map(menu -> {
            menuPlatesList = menuPlatesService.findByMenu(menu);
            platesList = MenuResponse.fromMenuPlatesListToPlatesList(menuPlatesList);
            return MenuResponse.fromMenu(menu, platesList);
        }).collect(Collectors.toList());
    }

    @Override
    public MenuResponse getMenuById(long id) {
        menu = findOrFail(id);
        menuPlatesList = menuPlatesService.findByMenu(menu);
        platesList = MenuResponse.fromMenuPlatesListToPlatesList(menuPlatesList);
        return MenuResponse.fromMenu(menu, platesList);
    }


    @Override
    public MenuResponse saveMenu(MenuRequest menuRequest) {
        menu = menuRepository.save(menuRequest.toMenu());
        menuPlatesList = MenuPlateDto.toEntityList(MenuPlateDto.fromRequestList(MenuDto.fromEntity(menu),menuRequest.getPlatesList()));

        menuPlatesListSaved.clear();

        menuPlatesListSaved = menuPlatesList.stream().map(menuPlate -> {
            menuPlate.setPlate(plateService.findOrFail(menuPlate.getPlate().getId()));
            return menuPlatesService.save(menuPlate);
            }).collect(Collectors.toList());
        return MenuResponse.fromMenu(menu, MenuResponse.fromMenuPlatesListToPlatesList(menuPlatesListSaved));
    }


    @Override
    public MenuResponse updateMenu(long id, MenuRequest menuRequest) {
        menuRequest.setId(findOrFail(id).getId());

        menu = menuRepository.save(menuRequest.toMenu());
        menuPlatesList = MenuPlateDto.toEntityList(MenuPlateDto.fromRequestList(MenuDto.fromEntity(menu),menuRequest.getPlatesList()));
        menuPlatesListSaved.clear();
        menuPlatesListSaved = menuPlatesList.stream().map(menuPlate -> {
            menuPlate.setPlate(plateService.findOrFail(menuPlate.getPlate().getId()));
            return menuPlate;
        }).collect(Collectors.toList());
        menuPlatesService.deleteByMenu(menu);
        menuPlatesService.saveAll(menuPlatesListSaved);

        return MenuResponse.fromMenu(menu, MenuResponse.fromMenuPlatesListToPlatesList(menuPlatesListSaved));
    }



    @Override
    @Transactional
    public void deleteMenu(long id) {
        menu = findOrFail(id);
        menuPlatesService.deleteByMenu(menu);
        menuRepository.delete(menu);
    }


    @Override
    public Menu findOrFail(long id) {
        return menuRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("The menu with id " + id + " does not exist"));
    }







    @Override
    public List<MenuResponse> getMenuByDate(String date) {
        menuList = menuRepository.findByDate(date);
        return menuList.stream().map(menu -> {
            menuPlatesList = menuPlatesService.findByMenu(menu);
            platesList = MenuResponse.fromMenuPlatesListToPlatesList(menuPlatesList);
            return MenuResponse.fromMenu(menu, platesList);
        }).collect(Collectors.toList());
    }

}


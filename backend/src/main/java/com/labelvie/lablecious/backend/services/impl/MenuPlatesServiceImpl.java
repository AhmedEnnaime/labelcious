package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.entity.Menu;
import com.labelvie.lablecious.backend.models.entity.MenuPlates;
import com.labelvie.lablecious.backend.repository.MenuPlatesRepository;
import com.labelvie.lablecious.backend.services.MenuPlatesService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MenuPlatesServiceImpl implements MenuPlatesService {

    private  final MenuPlatesRepository menuPlatesRepository;

    @Override
    public List<MenuPlates> findAll() {
        return menuPlatesRepository.findAll();
    }

    @Override
    public MenuPlates findById(Long id) {
        return findOrFail(id);
    }

    @Override
    public MenuPlates save(MenuPlates menuPlates) {
        return menuPlatesRepository.save(menuPlates);
    }

    @Override
    public List<MenuPlates>  saveAll(List<MenuPlates> menuPlates) {
        return menuPlatesRepository.saveAll(menuPlates);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public MenuPlates update(Long id, MenuPlates menuPlates) {
        return null;
    }

    @Override
    public List<MenuPlates> findByMenu(Menu menu){
        return menuPlatesRepository.findByMenu(menu);
    }




    @Override
    @Transactional
    public void deleteByMenu(Menu menu) {
        menuPlatesRepository.deleteByMenu(menu);
    }



    @Override
    public MenuPlates findOrFail(Long id) {
        return menuPlatesRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("The menu with id " + id + " does not exist"));
    }
}

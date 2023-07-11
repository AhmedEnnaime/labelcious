package com.labelvie.lablecious.backend.services;

import com.labelvie.lablecious.backend.models.entity.Menu;
import com.labelvie.lablecious.backend.transfer.request.MenuRequest;
import com.labelvie.lablecious.backend.transfer.response.MenuResponse;

import java.util.List;

public interface MenuService {

    List<MenuResponse> getMenus();
    MenuResponse getMenuById(long id);
    MenuResponse saveMenu(MenuRequest menu);
    MenuResponse updateMenu(long id, MenuRequest menu);
    void deleteMenu(long id);
    Menu findOrFail(long id);

    List<MenuResponse> getMenuByDate(String date);
}

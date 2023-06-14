package com.labelvie.lablecious.backend.services;

import com.labelvie.lablecious.backend.models.entity.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService {

    List<Menu> getMenus();

    Menu saveMenu(Menu menu);

    Menu createMenuWithPlates(Menu menu, Map<Long, Integer> plateQuantityMap);
}

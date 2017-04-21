package com.labawang.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labawang.business.MenuMapper;
import com.labawang.model.Menu;
import com.labawang.service.MenuService;

@Service("menuService")
public class MenuServiceImp implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	public List<Menu> getMenuByRoleId(Integer roleId) {
		List<Menu> menuListAll = menuMapper.getMenuListAll(roleId);
		if(menuListAll==null){
			return null;
		}
		
		for (Menu menu : menuListAll) {
			List<Menu> menuNextListAll = menuMapper.getMenuNextListAll(menu.getId());
			menu.setListMenu(menuNextListAll);
		}
		
		return menuListAll;
	}

}

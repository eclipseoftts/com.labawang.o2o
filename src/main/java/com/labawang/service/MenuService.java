package com.labawang.service;

import java.util.List;
import java.util.Map;

import com.labawang.model.Menu;

public interface MenuService {

	public List<Menu> getMenuByRoleId(Integer roleId);
}

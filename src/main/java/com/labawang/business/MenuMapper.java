package com.labawang.business;

import java.util.List;

import com.labawang.model.Menu;

public interface MenuMapper {
	
	/***
	 * 根据角色id查询按钮
	 * @param roleId
	 * @return
	 */
	List<Menu> getMenuListAll(Integer roleId);
	
	/***
	 * 查询子菜单
	 * @param menuId
	 * @return
	 */
	List<Menu> getMenuNextListAll(Integer menuId);
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}
package com.labawang.service;

import java.util.List;
import java.util.Map;

import com.labawang.model.Role;
import com.labawang.utils.ErrorInfo;

public interface RoleService {

	/***
	 * 根据角色id 查询
	 * @param roleId
	 * @return
	 */
	public Role getRoleByRoleId(Integer roleId);
	
	
	/***
	 * 查询所有的角色名称
	 * @param id
	 * @return
	 */
	
	public List<ErrorInfo> getRoleNameAll();
}

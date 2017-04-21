package com.labawang.business;

import java.util.List;
import java.util.Map;

import com.labawang.model.Role;
import com.labawang.utils.ErrorInfo;

public interface RoleMapper {
	
	/***
	 * 查询所有的角色名称
	 * @param id
	 * @return
	 */
	List<ErrorInfo> getRoleNameAll();
	
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role getRoleByRoleId(Integer remarks);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}
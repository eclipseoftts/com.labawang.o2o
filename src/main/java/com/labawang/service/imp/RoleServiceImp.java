package com.labawang.service.imp;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.labawang.business.MenuMapper;
import com.labawang.business.RoleMapper;
import com.labawang.model.Role;
import com.labawang.service.RoleService;
import com.labawang.utils.ErrorInfo;

@Service("roleService")
public class RoleServiceImp implements RoleService {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private RoleMapper roleMapper;
	
	public Role getRoleByRoleId(Integer roleId) {
		Role role = null;
		try {
			role = roleMapper.getRoleByRoleId(roleId);
		} catch (Exception e) {
			logger.error("根据角色ID查询时出错了！");
			return null;
		}
		return role;
	}
	
	/***
	 * 查询所有的角色名称
	 * @param id
	 * @return
	 */
	public List<ErrorInfo> getRoleNameAll(){
		try {
			return roleMapper.getRoleNameAll();
		} catch (Exception e) {
			logger.error("查询所有的角色名称！");
			e.printStackTrace();
			return null;
		}
		
	}

}

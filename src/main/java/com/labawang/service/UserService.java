package com.labawang.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageInfo;
import com.labawang.model.Users;
import com.labawang.utils.ErrorInfo;

public interface UserService {

	public Users getUsersByName(String name);
	
	public void getUsersByLogin(String name,String password,HttpSession session,ErrorInfo error);
	
	/***
	 * 查询所有用户
	 * @param id
	 * @return
	 */
	public PageInfo<Users> getUsersAll(Integer pageNum,Integer pageSize,ErrorInfo error);
	
	/***
	 * 根据id查询用户信心
	 * @param id
	 * @return
	 */
	public Users getUsersById(Integer id);
	
	/***
	 * 查询用户数量
	 * @param users
	 */
	public int getUsersCount();
	
	/***
	 * 修改用户信息
	 * @param id
	 * @return
	 */
	
	/***
     * 添加用户信息
     * @param record
     * @return
     */
    int insertSelective(Users record);
    
    /***
	 * 根据用户名模糊查询
	 * @param id
	 * @return
	 */
    public List<Users> getUserByName(String name);
	
	
	public int updateUsers(Users users);
	
	public void deleteUsers(Integer id,ErrorInfo error);
}

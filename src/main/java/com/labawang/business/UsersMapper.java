package com.labawang.business;

import java.util.Date;
import java.util.List;

import com.labawang.model.Users;

public interface UsersMapper {
	
	/***
	 * 根据名字查询用户信息
	 * @param name
	 * @return
	 */
	Users getUsersByName(String name);
	
	/***
	 * 查询所有用户
	 * @param id
	 * @return
	 */
	List<Users> getUsersAll();
	
	/***
	 * 查询用户数量
	 * @param id
	 * @return
	 */
	int getUsersCount();
	
	/***
	 * 修改用户信息
	 * @param id
	 * @return
	 */
	
	int updateByPrimaryKeySelective(Users record);
	
	/***
	 * 根据用户名模糊查询
	 * @param id
	 * @return
	 */
	List<Users> getUserByName(String name);
	
	
    int deleteByPrimaryKey(Integer id);


    /***
     * 添加用户信息
     * @param record
     * @return
     */
    int insertSelective(Users record);
    /***
     * 根据id查询
     * @param id
     * @return
     */
    Users getUsersById(Integer id);

    Users selectByPrimaryKey(Integer id);


}
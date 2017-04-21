package com.labawang.service.imp;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.labawang.business.UsersMapper;
import com.labawang.model.Users;
import com.labawang.service.UserService;
import com.labawang.utils.ErrorInfo;
import com.labawang.utils.Tools;

import sun.misc.BASE64Encoder;

@Service("userService")
public class UserServiceImp implements UserService {
	
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private UsersMapper usersMapper;
	
	/***
	 * 根据用户名查询用户
	 */
	public Users getUsersByName(String name) {
		try {
			return usersMapper.getUsersByName(name);
		} catch (Exception e) {
			logger.error("根据用户名查询时错误！");
			e.printStackTrace();
			return null;
		}
	}
	

	/***
	 * 用户登录密码验证
	 */
	public void getUsersByLogin(String name, String password,HttpSession session, ErrorInfo error) {
		Users users = getUsersByName(name);
		if(null==users){
			error.setCode(0);
			error.setError("用户名不存在！");
			return ;
		}
		String sha1 = Tools.getSha1(password);
		if(!sha1.equals(users.getPassword())){
			error.setCode(0);
			error.setError("用户名和密码错误！");
			return ;
		}
		error.setCode(1);
		error.setError("用户名和密码错误！");
		session.removeAttribute("user");
		session.setAttribute("user", users);
		return ;
	}
	
	/***
	 * 查询所有用户
	 * @param id
	 * @return
	 */
	public PageInfo<Users> getUsersAll(Integer pageNum,Integer pageSize,ErrorInfo error){
		Page<Users> startPage = PageHelper.startPage(pageNum, pageSize);
			try {
				List<Users> usersAll = usersMapper.getUsersAll();
				PageInfo<Users> pageInfo = new PageInfo<Users>(usersAll);
				return pageInfo;
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("查询用户所有信息时错误！");
				error.setCode(-1);
				error.setError("系统错误！");
				return null;
			}
	}
	
	/***
	 * 查询用户数量
	 * @param users
	 */
	public int getUsersCount(){
		try {
			return usersMapper.getUsersCount();
		} catch (Exception e) {
			logger.error("查询用户数量！");
			e.printStackTrace();
			return 0;
		}
	}
	
	/***
	 * 修改用户信息
	 * @param id
	 * @return
	 */
	
	public int updateUsers(Users record){
		try {
			return usersMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			logger.error("修改用户信息！");
			e.printStackTrace();
			return 0;
		}
	}
	
	/***
     * 添加用户信息
     * @param record
     * @return
     */
    public int insertSelective(Users user){
    	try {
			return usersMapper.insertSelective(user);
		} catch (Exception e) {
			logger.error("添加用户信息！");
			e.printStackTrace();
			return 0;
		}
    }
	

    /***
     * 根据用户id查询用户信息
     */
	public Users getUsersById(Integer id) {
		try {
			return usersMapper.getUsersById(id);
		} catch (Exception e) {
			logger.error("根据用户id查询时！");
			e.printStackTrace();
			return null;
		}
	}



	/***
	 * 删除用户信息
	 */
	public void deleteUsers(Integer id,ErrorInfo error) {
		try {
			usersMapper.deleteByPrimaryKey(id);
			error.setCode(1);
			error.setError("删除成功！");
		} catch (Exception e) {
			error.setCode(0);
			error.setError("删除失败！");
			logger.error("根据用户id查询时！");
			e.printStackTrace();
		}
	}
	
	/***
	 * 根据用户名模糊查询
	 * @param id
	 * @return
	 */
	public List<Users> getUserByName(String name){
		try {
			return usersMapper.getUserByName(name);
		} catch (Exception e) {
			logger.error("根据用户名模糊查询时！");
			e.printStackTrace();
			return null;
		}
	}

}

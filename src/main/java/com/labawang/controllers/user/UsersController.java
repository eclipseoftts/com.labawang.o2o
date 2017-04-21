package com.labawang.controllers.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageInfo;
import com.labawang.model.Menu;
import com.labawang.model.Users;
import com.labawang.service.RoleService;
import com.labawang.service.UserService;
import com.labawang.utils.DateFormatUtils;
import com.labawang.utils.ErrorInfo;
import com.labawang.utils.StringUtil;
import com.labawang.utils.Tools;

import net.sf.json.JSON;

@Controller
@RequestMapping("user")
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	/***
	 * 查询用户信息
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/queryUser.do")
	public ModelAndView getUsersByUsersId(HttpServletRequest request,Integer pageNum,Integer pageSize){
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		ErrorInfo error = new ErrorInfo();
		if(user.getRole().getRemarks()==0){
			PageInfo<Users> usersAll = userService.getUsersAll(pageNum,pageSize,error);
			model.addObject("usersAll", usersAll);
			model.addObject("type", 1);
		}else{
			Users users = userService.getUsersById(user.getId());
			model.addObject("users", users);
			model.addObject("type", 0);
		}
		model.addObject("menuList", (List<Menu>)session.getAttribute("menuList"));
		model.setViewName("/views/user/getUsersAll");
		return model;
	}
	
	/***
	 * 跳转到添加修改页面
	 * @param type
	 * @param request
	 * @return
	 */
	@GetMapping("/saveUsers.do")
	public ModelAndView saveUsers(String type,HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		if(StringUtil.isNumeric(type)){
			Users users = userService.getUsersById(Integer.parseInt(type));
			model.addObject("users", users);
		}
		List<ErrorInfo> roleList = roleService.getRoleNameAll();
		model.addObject("error", type);
		model.addObject("roleList", roleList);
		model.addObject("menuList", (List<Menu>)request.getSession().getAttribute("menuList"));
		model.setViewName("/views/user/user_edit");
		return model;
	}
	
	
	/***
	 * 添加用户信息提交
	 * @param name
	 * @param password
	 * @param username
	 * @param telephone
	 * @param roleId
	 * @param request
	 * @return
	 */
	@PostMapping(value="/saveUsersAll.do")
	public ModelAndView  saveUsersAll(String userId,String name,String password,String username,
			String telephone,Integer roleId,HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		String error = "";
		if(StringUtil.isEmpty(name)||StringUtil.isEmpty(password)){
			error = "用户名和密码不能为空！";
		}else{
			Users user = userService.getUsersByName(name);
			if(user!=null){
				error = "用户名已存在重新输入！";
			}else{
				String sha1 = Tools.getSha1(password);
				if(StringUtil.notEmpty(userId)){
					Users users = new Users(Integer.parseInt(userId),name, sha1, "1", roleId, username, DateFormatUtils.dateFormat(new Date()), null, telephone);
					int updateByUsers = userService.updateUsers(users);
					if(updateByUsers==1){
						try {
							error = new String("用户名修改成功！".getBytes("UTF-8"));
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}else{
						try {
							error = new String("用户名修改失败！".getBytes("UTF-8"));
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
					model.addObject("pageNum",0);
					model.addObject("pageSize",10);
					model.setViewName("redirect:./queryUser.do");
			        return model;
				}
				Users users = new Users(name, sha1, "1", roleId, username, DateFormatUtils.dateFormat(new Date()), null, telephone);
				int insertSelective = userService.insertSelective(users);
				if(insertSelective==1){
					try {
						error = new String("用户名添加成功！".getBytes("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else{
					try {
						error = new String("用户名添加失败！".getBytes("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				model.addObject("type",error);
				model.setViewName("redirect:./saveUsers.do");
		        return model;
			}
		}
		model.addObject("type",error);
		model.setViewName("redirect:./saveUsers.do");
        return model;
	}
	
	/***
	 * 删除用户信息
	 */
	@GetMapping("/deleteUsers.do")
	public @ResponseBody void deleteUsers(String userId,HttpServletResponse response) {
		ErrorInfo error = new ErrorInfo();
		String[] arr = userId.split(",");
		for (String id : arr) {
			userService.deleteUsers(Integer.parseInt(id), error);
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
        printWriter.write(error.getError());  
        printWriter.flush();  
        printWriter.close();  
		
	}
	
	/***
	 * 查询用户信息
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/queryUserByName.do")
	public ModelAndView getUsersByUsersId(HttpServletRequest request,String name){
		ModelAndView model = new ModelAndView();
		List<Users> userByName = userService.getUserByName(name);
		model.addObject("usersAll", userByName);
		model.setViewName("/views/user/getUsersAll");
		return model;
	}
	
	
	
	
}

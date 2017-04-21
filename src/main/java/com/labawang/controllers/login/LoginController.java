package com.labawang.controllers.login;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.labawang.model.Menu;
import com.labawang.model.Role;
import com.labawang.model.Users;
import com.labawang.service.MenuService;
import com.labawang.service.RoleService;
import com.labawang.service.UserService;
import com.labawang.utils.DateFormatUtils;
import com.labawang.utils.ErrorInfo;
import com.labawang.utils.StringUtil;
import com.labawang.utils.Tools;


@Controller
@RequestMapping("login")
public class LoginController {
	
	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuService;
	

	/***
	 * 跳转到登录页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,  
            HttpServletResponse response){
		return "/views/user/login";
	}
	
	/***
	 * 登录页面信息提交
	 * 	@RequestMapping("/loginInit.do")
	 * @param name
	 * @param password
	 * @param request
	 * @return
	 */
	@PostMapping("/loginInit.do")
	public ModelAndView loginInit(String name,String password,HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		if(StringUtil.isEmpty(name)||StringUtil.isEmpty(password)){
			model.addObject("error", "用户名和密码不能空！");
			model.setViewName("/views/user/login");
			return model;
		}
		HttpSession session = request.getSession();
		ErrorInfo error = new ErrorInfo();
		userService.getUsersByLogin(name, password, session, error);
		if(error.getCode()<=0){
			model.addObject("error", error.getError());
			model.setViewName("/views/user/login");
			return model;
		}
		model.setViewName("redirect:./home.do");
		return model;
	}
	
	/***
	 * 登录成功首页
	 * @param request
	 * @return
	 */
	@RequestMapping("/home.do")
	public ModelAndView home(HttpServletRequest request){
		HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView();
		Users user = (Users)session.getAttribute("user");
		if(user==null){
			model.addObject("error", "重新登录");
			model.setViewName("/views/user/login");
			return model;
		}
		int usersCount = userService.getUsersCount();
		if(user.getRole()!=null){
			List<Menu> menuByRoleId = (List<Menu>)session.getAttribute("menuList");
			model.addObject("menuList", menuByRoleId);
			model.addObject("usersCount", usersCount);
			model.setViewName("/views/home/home");
			return model;
		}
		
		Role role = roleService.getRoleByRoleId(user.getRoleid());
		
		if(role==null){
			model.addObject("error", "没有任何权限！");
			model.setViewName("/views/user/login");
			return model;
		}
		Users use = new Users();
		use.setId(user.getId());
		use.setIp(Tools.getClientIpAddress(request));
		System.out.println(Tools.getClientIpAddress(request)+"==================="+user.getId());
		use.setLastLogin(DateFormatUtils.dateFormat(new Date()));
		try {
			userService.updateUsers(user);
		} catch (Exception e) {
			logger.error("添加用户登录时错误！");
			e.printStackTrace();
		}
		
		user.setRole(role);
		session.removeAttribute("user");
		session.setAttribute("user", user);
		List<Menu> menuByRoleId = menuService.getMenuByRoleId(role.getRemarks());
		session.setAttribute("menuList", menuByRoleId);
		model.addObject("menuList", menuByRoleId);
		model.addObject("usersCount", usersCount);
		
		model.setViewName("/views/home/home");
		return model;
	}
	
	/***
	 * 安全退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/quit.do")
	public String quit(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "redirect:./login.do";
	}
	
	
	
	
}

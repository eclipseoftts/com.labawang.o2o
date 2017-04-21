package com.labawang.controllers.role;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("role")
public class RoleController {

	
	/***
	 * 权限管理
	 * 
	 */
	@GetMapping("/editRole.do")
	public ModelAndView editRole(){
		
		return null;
	}
}

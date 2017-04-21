package com.labawang.controllers.Customer;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.labawang.entity.SearchCustomer;
import com.labawang.model.Customer;
import com.labawang.model.Menu;
import com.labawang.model.Users;
import com.labawang.service.CustomerService;
import com.labawang.utils.Constants;
import com.labawang.utils.DateFormatUtils;
import com.labawang.utils.ErrorInfo;
import com.labawang.utils.Tools;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	/***
	 * 查询所有的客户信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/queryCustomer.do")
	public ModelAndView getCustomer(Integer pageNum,HttpServletRequest request){
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		PageInfo<Customer> customerAll = null;
		Integer remarks = user.getRole().getRemarks();
		if(remarks==0){
			customerAll = customerService.getCustomerAll(pageNum, Constants.pageSize);
		}else{
			customerAll = customerService.getCustomerAllByUserId(pageNum, Constants.pageSize,user.getId());
		}
		
		ModelAndView model = new ModelAndView();
		Map<Integer, String> map = new HashMap<Integer, String>();
		map = Tools.getSearch(map, remarks);
		model.addObject("customerAll", customerAll);
		model.addObject("user", user);
		model.addObject("map", map);
		model.setViewName("/views/customer/getCustomerAll");
		return model;
	}
	
	
	/***
	 * 保存用户信息
	 * @param company
	 * @param address
	 * @param job
	 * @param name
	 * @param grade
	 * @param telephone
	 * @param industry
	 * @param product
	 * @param advertising
	 * @param remarks
	 * @param request
	 * @return
	 */
	@PostMapping("/setCustomerAll.do")
	public ModelAndView getCustomerAll(Integer id ,Integer userid,String company, String address, String job,  String name, Integer grade,
			 String telephone, String industry, String product, String advertising, String remarks,HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		String msg = "";
		ErrorInfo error = new ErrorInfo();
		if(StringUtil.isEmpty(company)||StringUtil.isEmpty(address)||StringUtil.isEmpty(job)||StringUtil.isEmpty(name)
				||StringUtil.isEmpty(telephone)||StringUtil.isEmpty(industry)||StringUtil.isEmpty(product)||
				StringUtil.isEmpty(advertising)||StringUtil.isEmpty(remarks)){
			msg = "请检查是否输入完整！";
		}else{
			if(com.labawang.utils.StringUtil.isNumeric(id+"")){
				Customer customer = new Customer(id,company, address, job, DateFormatUtils.dateFormat(new Date()), name, grade,
						userid, telephone, industry, product, advertising, remarks);
				customerService.updateByPrimaryKeySelective(customer,error);
				Customer customer2 = customerService.getCustomerById(id);
				model.addObject("company", customer2);
				msg = "修改成功！";
			}else{
				Customer customer = new Customer(company, address, job, DateFormatUtils.dateFormat(new Date()), name, grade,
						userid, telephone, industry, product, advertising, remarks);
				customerService.setCustomer(customer, error);
				msg = error.getError();
			}
		}
		model.addObject("error", msg);
		model.setViewName("/views/customer/customer_edit");
		return model;
	}
	
	/***
	 * 跳转到添加页面
	 */
	@GetMapping("/editCustomer.do")
	public ModelAndView editCustomer(String type,HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		if(com.labawang.utils.StringUtil.isNumeric(type)){
			int id = Integer.parseInt(type);
			Customer customer = customerService.getCustomerById(id);
			model.addObject("company", customer);
		}
		model.addObject("menuList", (List<Menu>)request.getSession().getAttribute("menuList"));
		model.setViewName("/views/customer/customer_edit");
		return model;
	}
	
	/***
	 * 跳转到添加页面
	 */
	@GetMapping("/deleteCustomer.do")
	public void deleteCustomer(String userid,HttpServletResponse response){
		String[] userId = userid.split(",");
		String error = "";
		try {
		for (int i = 0; i < userId.length; i++) {
				customerService.deleteByPrimaryKey(Integer.parseInt(userId[i]));
				error = "删除成功";
		}
		} catch (Exception e) {
			error = "删除失败";
			e.printStackTrace();
		}
		System.out.println(error);
		response.setCharacterEncoding("utf-8");
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
        printWriter.write(error);  
        printWriter.flush();  
        printWriter.close();  
	}
	
	@PostMapping("/getCustomerSearch.do")
	public ModelAndView getCustomerSearch(Integer type,String name,HttpServletRequest request){
		SearchCustomer search = new SearchCustomer();
		switch (type) {
		case 1:
			search.setTelephone(name);
			break;
		case 2:
			search.setIndustry(name);
			break;
		case 3:
			search.setName(name);
			break;
		case 4:
			search.setUserName(name);
			break;
		}
	    PageInfo<Customer> customerSearch = customerService.getCustomerSearch(search,0);
	    Users user = (Users)request.getSession().getAttribute("user");
		Map<Integer, String> map = new HashMap<Integer, String>();
		map = Tools.getSearch(map, user.getRole().getRemarks());
	    ModelAndView model = new ModelAndView();
	    model.addObject("customerAll", customerSearch);
	    model.addObject("user", user);
		model.addObject("map", map);
		model.addObject("type", type);
		model.addObject("name", name);
		model.setViewName("/views/customer/getCustomerAll");
		return model;
	}
	
	
	
	
	
}

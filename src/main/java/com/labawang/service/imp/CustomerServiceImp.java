package com.labawang.service.imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.labawang.business.CustomerMapper;
import com.labawang.entity.SearchCustomer;
import com.labawang.model.Customer;
import com.labawang.model.Users;
import com.labawang.service.CustomerService;
import com.labawang.utils.Constants;
import com.labawang.utils.ErrorInfo;

@Service("customerService")
public class CustomerServiceImp implements CustomerService {
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private CustomerMapper customerMapper;

	/***
	 * 查询所有客户
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Customer> getCustomerAll(Integer pageNum,Integer pageSize){
		Page<Users> startPage = PageHelper.startPage(pageNum, pageSize);
		try {
			List<Customer> customerAll = customerMapper.getCustomerAll();
			PageInfo<Customer> pageInfo = new PageInfo<Customer>(customerAll);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询用户所有信息时错误！");
			return null;
		}
	}
	
	/***
	 * 查询所有客户
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Customer> getCustomerAllByUserId(Integer pageNum,Integer pageSize,Integer userId){
		Page<Users> startPage = PageHelper.startPage(pageNum, pageSize);
		try {
			List<Customer> customerAll = customerMapper.getCustomerAllByUserId(userId);
			PageInfo<Customer> pageInfo = new PageInfo<Customer>(customerAll);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询用户所有信息时错误！");
			return null;
		}
	}
	
	
	/***
	 * 保存客户
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public void setCustomer(Customer customer,ErrorInfo error){
		try {
			customerMapper.insertSelective(customer);
			error.setCode(1);
			error.setError("添加成功！");
		} catch (Exception e) {
			error.clear();
			error.setCode(1);
			error.setError("添加失败！");
			logger.error("添加客户信息时错误！");
			e.printStackTrace();
			return ;
		}
		
	}
	
	/***
	 * 根据id 查询客户信息
	 * @param id
	 * @return
	 */
	public Customer selectByPrimaryKey(Integer id){
		try {
			return customerMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("根据id 查询客户信息时失败！");
			e.printStackTrace();
			return null;
		}
		
	}
	
	/***
	 * 修改客户信息
	 * @param record
	 * @return
	 */
	public void updateByPrimaryKeySelective(Customer record,ErrorInfo error){
		try {
			customerMapper.updateByPrimaryKeySelective(record);
			error.setCode(1);
			error.setError("修改成功！");
		} catch (Exception e) {
			error.clear();
			error.setCode(0);
			error.setError("修改成功！");
			logger.error("根据id 修改客户信息时失败！");
			e.printStackTrace();
		}
	}
	
	/***
	 * 删除用户信息
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id) throws Exception{
			return customerMapper.deleteByPrimaryKey(id);
	}
	
	/***
     * 
     * @param record
     * @return
     */
    public Customer getCustomerById(Integer id){
    	try {
    		Customer customer = customerMapper.getCustomerById(id);
			return customer;
		} catch (Exception e) {
			logger.error("根据id 查询客户信息时失败！");
			e.printStackTrace();
			return null;
		}
    }
    
    /***
     * 根据搜索条件查询客户信息
     * @param record
     * @return
     */
   public PageInfo<Customer> getCustomerSearch(SearchCustomer record,Integer pageNum){
	   Page<Users> startPage = PageHelper.startPage(pageNum, Constants.pageSize);
		try {
			List<Customer> customerAll = customerMapper.getCustomerSearch(record);
			PageInfo<Customer> pageInfo = new PageInfo<Customer>(customerAll);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询用户所有信息时错误！");
			return null;
		}
    }
	
	
}

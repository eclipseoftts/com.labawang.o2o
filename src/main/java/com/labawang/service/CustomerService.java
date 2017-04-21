package com.labawang.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.labawang.entity.SearchCustomer;
import com.labawang.model.Customer;
import com.labawang.utils.ErrorInfo;

public interface CustomerService {

	/***
	 * 查询所有客户
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Customer> getCustomerAll(Integer pageNum,Integer pageSize);
	
	/***
	 * 查询所有客户
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Customer> getCustomerAllByUserId(Integer pageNum,Integer pageSize,Integer userId);
	
	/***
	 * 保存客户
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public void setCustomer(Customer customer,ErrorInfo error);
	
	/***
	 * 根据id 查询客户信息
	 * @param id
	 * @return
	 */
	public Customer selectByPrimaryKey(Integer id);
	
	/***
	 * 修改客户信息
	 * @param record
	 * @return
	 */
	public void updateByPrimaryKeySelective(Customer record,ErrorInfo error);
	
	/***
	 * 删除用户信息
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id) throws Exception;
	
	/***
     * 
     * @param record
     * @return
     */
	public Customer getCustomerById(Integer id);
    
    /***
     * 根据搜索条件查询客户信息
     * @param record
     * @return
     */
    public PageInfo<Customer> getCustomerSearch(SearchCustomer record,Integer pageNum);
}

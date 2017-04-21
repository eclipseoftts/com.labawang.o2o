package com.labawang.business;

import java.util.List;

import com.labawang.entity.SearchCustomer;
import com.labawang.model.Customer;

public interface CustomerMapper {
	
	/***
	 * 查询所有客户
	 * @param id
	 * @return
	 */
	List<Customer> getCustomerAll();
	
	/***
	 * 查询所有客户
	 * @param id
	 * @return
	 */
	List<Customer> getCustomerAllByuserId();
	
	
	/***
	 * 查询用户id客户
	 * @param id
	 * @return
	 */
	List<Customer> getCustomerAllByUserId(Integer userId);
	/***
	 * 保存客户信息
	 * @param record
	 * @return
	 */
	int insertSelective(Customer record);
	
	/***
	 * 根据id 查询客户信息
	 * @param id
	 * @return
	 */
	Customer selectByPrimaryKey(Integer id);
	
	/***
	 * 修改客户信息
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Customer record);
	
	/***
	 * 删除用户信息
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);
    
    /***
     * 根据id查询客户信息
     * @param record
     * @return
     */
    Customer getCustomerById(Integer id);
    
    /***
     * 根据搜索条件查询客户信息
     * @param record
     * @return
     */
    List<Customer> getCustomerSearch(SearchCustomer record);

    int insert(Customer record);




    int updateByPrimaryKeyWithBLOBs(Customer record);

    int updateByPrimaryKey(Customer record);
}
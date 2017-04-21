package com.labawang.model;

import java.util.Date;

public class Customer {
    private Integer id;

    private String company;

    private String address;

    private String job;

    private Date intime;

    private String name;

    private Integer grade;

    private Integer userid;

    private String telephone;

    private String industry;

    private String product;

    private String advertising;

    private String remarks;
    
    
    public Customer(){
    	super();
    }

    public Customer(Integer id,String company, String address, String job, Date intime, String name, Integer grade,
			Integer userid, String telephone, String industry, String product, String advertising, String remarks) {
		super();
		this.id = id;
		this.company = company;
		this.address = address;
		this.job = job;
		this.intime = intime;
		this.name = name;
		this.grade = grade;
		this.userid = userid;
		this.telephone = telephone;
		this.industry = industry;
		this.product = product;
		this.advertising = advertising;
		this.remarks = remarks;
	}
    public Customer( String company, String address, String job, Date intime, String name, Integer grade,
    		Integer userid, String telephone, String industry, String product, String advertising, String remarks) {
    	super();
    	this.company = company;
    	this.address = address;
    	this.job = job;
    	this.intime = intime;
    	this.name = name;
    	this.grade = grade;
    	this.userid = userid;
    	this.telephone = telephone;
    	this.industry = industry;
    	this.product = product;
    	this.advertising = advertising;
    	this.remarks = remarks;
    }

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getAdvertising() {
        return advertising;
    }

    public void setAdvertising(String advertising) {
        this.advertising = advertising == null ? null : advertising.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
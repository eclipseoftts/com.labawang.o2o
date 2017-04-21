package com.labawang.model;

import java.util.Date;

public class Users {
    private Integer id;

    private String name;

    private String password;

    private String isstart;

    private Integer roleid;

    private String username;

    private Date lastLogin;

    private String ip;

    private String telephone;
    
    private Role role;
    
    
    public Users(){
    	super();
    }

    public Users(String name, String password, String isstart, Integer roleid, String username,
			Date lastLogin, String ip, String telephone) {
		super();
		this.name = name;
		this.password = password;
		this.isstart = isstart;
		this.roleid = roleid;
		this.username = username;
		this.lastLogin = lastLogin;
		this.ip = ip;
		this.telephone = telephone;
	}
    
    public Users(Integer id,String name, String password, String isstart, Integer roleid, String username,
    		Date lastLogin, String ip, String telephone) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.password = password;
    	this.isstart = isstart;
    	this.roleid = roleid;
    	this.username = username;
    	this.lastLogin = lastLogin;
    	this.ip = ip;
    	this.telephone = telephone;
    }

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIsstart() {
        return isstart;
    }

    public void setIsstart(String isstart) {
        this.isstart = isstart == null ? null : isstart.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin ;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
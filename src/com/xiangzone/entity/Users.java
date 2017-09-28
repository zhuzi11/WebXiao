package com.xiangzone.entity;

import java.io.Serializable;

public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int no;
	private String name;
	private String pwd;
	private String phone;
	private String sex;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Users(int no, String name, String pwd, String phone, String sex) {
		super();
		this.no = no;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.sex = sex;
	}
	public Users() {
		super();
	}
}

package com.xiangzone.dao;

import com.xiangzone.entity.Users;

public interface UsersDao extends Common<Users>{

	public Users login(String loginName, String loginPwd);
}

package com.xiangzone.biz;

import com.xiangzone.entity.Users;

public interface UsersBiz extends Common<Users> {

	public Users login(String name, String pwd);

}

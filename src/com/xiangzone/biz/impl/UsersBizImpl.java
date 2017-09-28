package com.xiangzone.biz.impl;

import java.util.List;

import com.xiangzone.biz.UsersBiz;
import com.xiangzone.dao.UsersDao;
import com.xiangzone.dao.impl.UsersDaoImpl;
import com.xiangzone.entity.Users;

public class UsersBizImpl implements UsersBiz {

	private UsersDao dao = new UsersDaoImpl();
	@Override
	public int insert(Users t) {
		return dao.insert(t);
	}

	@Override
	public Users queryByno(Users t) {
		return dao.queryByno(t);
	}

	@Override
	public Users login(String name, String pwd) {
		return dao.login(name, pwd);
	}

	@Override
	public List<Users> queryAll(int no) {
		return dao.queryAll(no);
	}

	@Override
	public int delete(Users t) {
		// TODO Auto-generated method stub
		return dao.delete(t);
	}

	@Override
	public int update(Users t) {
		// TODO Auto-generated method stub
		return dao.update(t);
	}

}

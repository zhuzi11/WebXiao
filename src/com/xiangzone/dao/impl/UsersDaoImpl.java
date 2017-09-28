package com.xiangzone.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xiangzone.dao.BaseDao;
import com.xiangzone.dao.UsersDao;
import com.xiangzone.entity.Users;

public class UsersDaoImpl extends BaseDao implements UsersDao {

	@Override
	public int insert(Users t) {
		String sql = "insert into users values(users_seq.nextval,?,?,?,?)";
		return super.executeUpdate(sql, t.getName(),t.getPwd(),t.getPhone(),t.getSex());
	}

	@Override
	public Users queryByno(Users t) {
		String sql = "select no,name,pwd,phone,sex from users where no = ?";
		List<Map<String, Object>> list = super.executeQuery(sql, t.getNo());
		if (list == null) {
			return null;
		}else{
			Map<String, Object> map = list.get(0);
			int no = ((BigDecimal) map.get("no")).intValue();
			String name = (String) map.get("name");
			String pwd = (String) map.get("pwd");
			String phone = (String) map.get("phone");
			String sex = (String) map.get("sex");
			Users user = new Users(no, name, pwd, phone, sex);
			return user;
		}
	}

	@Override
	public Users login(String name, String pwd) {
		String sql = "select no,name,pwd,phone,sex from users where name=? and pwd=?";
		List<Map<String, Object>> list = super.executeQuery(sql, name,pwd);
		if (list.size() == 0) {
			return null;
		}else{
			Map<String, Object> map = list.get(0);
			int no = ((BigDecimal) map.get("no")).intValue();
			String xname = (String) map.get("name");
			String xpwd = (String) map.get("pwd");
			String phone = (String) map.get("phone");
			String sex = (String) map.get("sex");
			Users user = new Users(no, xname, xpwd, phone, sex);
			return user;
		}
	}

	@Override
	public List<Users> queryAll(int no) {
		String sql = "select no,name,phone,sex from users where no != ?";
		List<Map<String, Object>> list = super.executeQuery(sql, no);
		List<Users> uList = new ArrayList<Users>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			int xno = ((BigDecimal) map.get("no")).intValue();
			String xname = (String) map.get("name");
			String xpwd = (String) map.get("pwd");
			String phone = (String) map.get("phone");
			String sex = (String) map.get("sex");
			Users user = new Users(xno, xname, xpwd, phone, sex);
			uList.add(user);
		}
		return uList;
	}

	@Override
	public int delete(Users t) {
		// TODO Auto-generated method stub
		String sql = "delete from users where no = ?";
		return super.executeUpdate(sql, t.getNo());
	}

	@Override
	public int update(Users t) {
		// TODO Auto-generated method stub
		String sql = "update users set name = ?,pwd = ?,phone = ?,sex = ? where no = ?";
		return super.executeUpdate(sql, t.getName(),t.getPwd(),t.getPhone(),t.getSex(),t.getNo());
	}

}

package com.xiangzone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDao {

	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String USER = "xiang";
	private static final String PASSWORD = "123";
	
	protected Connection con;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @return 获取数据库连接
	 * @throws SQLException
	 */
	public Connection openConnection() throws SQLException{
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	/**
	 * 关闭连接，释放资源
	 * @param con
	 * @param pstmt
	 * @param rs
	 * @throws SQLException
	 */
	public void closeAll(Connection con,PreparedStatement pstmt,ResultSet rs) throws SQLException{
		if (con != null) {
			con.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (rs != null) {
			rs.close();
		}
	}
	/**
	 * 
	 * @param sql
	 * @param objs 可变长度的参数
	 * @return
	 */
	public int executeUpdate(String sql,Object...objs){
		try {
			this.con = this.openConnection();
			this.pstmt = this.con.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					this.pstmt.setObject(i + 1, objs[i]);
				}
			}
			return this.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				this.closeAll(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
		
	}
	/**
	 * 
	 * @param sql
	 * @param objs
	 * @return
	 */
	public List<Map<String, Object>> executeQuery(String sql,Object...objs){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		try {
			this.con = this.openConnection();
			this.pstmt = this.con.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					this.pstmt.setObject(i + 1, objs[i]);
				}
			}
			this.rs = this.pstmt.executeQuery();
			
			ResultSetMetaData meta = this.rs.getMetaData();
			int columnCount = meta.getColumnCount();
			while (this.rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					String key = meta.getColumnName(i).toLowerCase();
					Object value = this.rs.getObject(i);
					map.put(key, value);
				}
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				this.closeAll(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
		
	}
}

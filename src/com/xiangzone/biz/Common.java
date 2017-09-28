package com.xiangzone.biz;

import java.util.List;

public interface Common<T> {

	public int insert(T t);
	
	public T queryByno(T t);
	
	public int delete(T t);
	
	public int update(T t);
	
	public List<T> queryAll(int no);
}

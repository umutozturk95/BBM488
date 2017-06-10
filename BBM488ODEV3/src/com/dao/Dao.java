package com.dao;

public interface  Dao {
	public void add(Object o);
	public void delete(int index);
	public Object list();
	public  void update(Object o,int index);
}

package com.repositories;

import java.util.List;

public interface IRepository<T> {
	
	public void add(T o);
	public void remove(int index);
	public void remove(T o);
	public void get(int index);
	public void modify(T o1, T o2);
	public void modify(int index, T o);
	public List<T> getAll();
	
}
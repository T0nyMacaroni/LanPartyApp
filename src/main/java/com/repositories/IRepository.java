package com.repositories;

import java.util.List;

public interface IRepository<T> {
	
	public void add(T o);
	public void remove(int index);
	public void remove(T o);
	public void get(int index);
	public List<T> getAll();
	
}
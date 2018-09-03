package com.repositories;

import java.util.List;

public interface IRepository<T> {
	
	public void add(T t);
	public void remove(int index);
	public void remove(T t);
	public void get(int index);
	public List<T> getAll();
	
}
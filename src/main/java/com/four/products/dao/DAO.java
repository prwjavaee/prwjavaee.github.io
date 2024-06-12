package com.four.products.dao;

import java.util.List;

public interface DAO<T> {
	T singleSearch(int id);

	List<T> searchAll();

	boolean insert(T obj);

	boolean update(T obj);

	boolean delete(List<Integer> id);
	
	List<T> fuzzySearch(String keyword);
 }

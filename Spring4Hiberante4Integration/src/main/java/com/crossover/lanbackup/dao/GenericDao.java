package com.crossover.lanbackup.dao;

import java.util.List;

public interface GenericDao<T, PK> {
	PK create(T entity);
	T update(T entity);
	void delete(PK id);
	T get(PK id);
	List<T> getAll();
}

package mz.course.application.store;

import java.util.List;

public interface BaseStore<T> {

	String create(T domain);

	void update(T domain);

	void delete(String id);

	T findById(String id);

	List<T> findAll();
}

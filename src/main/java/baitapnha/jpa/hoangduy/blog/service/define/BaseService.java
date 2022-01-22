package baitapnha.jpa.hoangduy.blog.service.define;

import java.util.List;

import org.springframework.stereotype.Service;


public interface BaseService<T> {
	public List<T> getAll();

	public void save(T object);

	public T getByID(int id);

	public void deleteById(int id) ;
	

}

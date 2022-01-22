package baitapnha.jpa.hoangduy.blog.service.define;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;





public interface PageService<T> {
	
    Page<T> findAll(Pageable pageable);

    T findById(int id);

    void save(T entity);

    void remove(int id);


    
    Page<T> findAllByTitleContaining(String title, Pageable pageable);
}
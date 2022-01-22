package baitapnha.jpa.hoangduy.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import baitapnha.jpa.hoangduy.blog.entity.Blog;
import baitapnha.jpa.hoangduy.blog.entity.Category;
import baitapnha.jpa.hoangduy.blog.repository.CategoryRepository;
import baitapnha.jpa.hoangduy.blog.service.define.BaseService;
import baitapnha.jpa.hoangduy.blog.service.define.PageService;

@Service
public class CategoryServiceImpl implements BaseService<Category> {

	@Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(Category category) {
    	categoryRepository.save(category);
    }	

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category getByID(int id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		categoryRepository.deleteById(id);
		
	}
}

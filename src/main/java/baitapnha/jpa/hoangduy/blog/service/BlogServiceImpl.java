package baitapnha.jpa.hoangduy.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import baitapnha.jpa.hoangduy.blog.entity.Blog;
import baitapnha.jpa.hoangduy.blog.repository.BlogRepository;
import baitapnha.jpa.hoangduy.blog.service.define.PageService;


@Service
public class BlogServiceImpl implements PageService<Blog> {

	@Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
    	blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
    	blogRepository.deleteById(id);
    }


    @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(title, pageable) ;
    }

}

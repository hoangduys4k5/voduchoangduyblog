package baitapnha.jpa.hoangduy.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import baitapnha.jpa.hoangduy.blog.entity.Blog;
import baitapnha.jpa.hoangduy.blog.entity.Comment;
import baitapnha.jpa.hoangduy.blog.repository.CommentRepository;
import baitapnha.jpa.hoangduy.blog.service.define.BaseService;
import baitapnha.jpa.hoangduy.blog.service.define.PageService;

@Service
public class CommentServiceImpl implements BaseService<Comment> {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public void save(Comment entity) {
		commentRepository.save(entity);
		
	}

//	public List<Comment> findAllById(int id) {
//	
//		// TODO Auto-generated method stub
//		return commentRepository.findAllById(id);
//		
//	}
	 public List<Comment> findAllByBlog(Blog blog) {
	        return commentRepository.findAllByBlog(blog);
	    }

	@Override
	public List<Comment> getAll() {
		// TODO Auto-generated method stub
		return commentRepository.findAll();
	}

	@Override
	public Comment getByID(int id) {
		// TODO Auto-generated method stub
		return commentRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		commentRepository.deleteById(id);
		
	}
	
	
	
	
	

}

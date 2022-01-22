package baitapnha.jpa.hoangduy.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import baitapnha.jpa.hoangduy.blog.entity.Blog;
import baitapnha.jpa.hoangduy.blog.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
//	@Query("SELECT c FROM comment c WHERE c.blog.id =?1")
//	List<Comment> findAllById(int id);
	
	List<Comment> findAllByBlog(Blog blog);
	
}

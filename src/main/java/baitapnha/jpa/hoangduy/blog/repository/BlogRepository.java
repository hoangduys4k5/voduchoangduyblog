package baitapnha.jpa.hoangduy.blog.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import baitapnha.jpa.hoangduy.blog.entity.Blog;


@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {

	Page<Blog> findAllByTitleContaining(String tile, org.springframework.data.domain.Pageable pageable);

}
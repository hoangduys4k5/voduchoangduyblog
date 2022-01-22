package baitapnha.jpa.hoangduy.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



import baitapnha.jpa.hoangduy.blog.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

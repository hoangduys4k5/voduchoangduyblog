package baitapnha.jpa.hoangduy.blog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import baitapnha.jpa.hoangduy.blog.entity.Blog;
import baitapnha.jpa.hoangduy.blog.entity.Category;
import baitapnha.jpa.hoangduy.blog.entity.Comment;
import baitapnha.jpa.hoangduy.blog.entity.TagName;
import baitapnha.jpa.hoangduy.blog.service.CommentServiceImpl;
import baitapnha.jpa.hoangduy.blog.service.define.BaseService;
import baitapnha.jpa.hoangduy.blog.service.define.PageService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private PageService<Blog> blogService;
	
	@Autowired
	private CommentServiceImpl commentService;
	
	@Autowired
	private BaseService<Category> categoryService;
	
	@Autowired
	private BaseService<TagName> tagnameService;
	@ModelAttribute("category")
	public List<Category> categories() {
		return categoryService.getAll();
	}
	@ModelAttribute("tagname")
	public List<TagName> tagnames() {
		return tagnameService.getAll();
	}
	
	@GetMapping("/page")
	public String listblogs( Pageable pageable,  Model theModel,@RequestParam("page") Optional<Integer> p) {
		Page<Blog> blogs;
//		if (s.isPresent()) {
//			blogs = blogService.findAllByFirstNameContaining(s.get(), pageable);
//		} else {
		pageable = PageRequest.of(p.orElse(0), 5);
			blogs = blogService.findAll(pageable);
			for(Blog each : blogs) {
				each.setComments(commentService.findAllByBlog(each));
			}
//		}
		theModel.addAttribute("blogs", blogs);

		return "user-list";
	}
	
	@GetMapping("/updateLike")
	public String showFormForUpdate(@RequestParam("blogId") int theId, Model theModel) {
		Blog theBlog = blogService.findById(theId);
		theBlog.setLike((theBlog.getLike()+1));
		blogService.save(theBlog);
		
		return "redirect:/user/page";
	}
	@GetMapping("/detailBlog")
	public String detailBlog(@RequestParam("blogId") int theId, Model theModel) {
		Blog theBlog = blogService.findById(theId);
		theBlog.setComments(commentService.findAllByBlog(theBlog));
		theModel.addAttribute("blog",theBlog);
		return "user-blog";
	}
	
	@PostMapping("/comment")
	public String comment(@RequestParam("id") int theId,@RequestParam("comment") String cmt, Model theModel) {
		
		Blog theBlog = blogService.findById(theId);
		Comment cmts = new Comment();
		cmts.setCmt(cmt);
		cmts.setBlog(theBlog);
		commentService.save(cmts);
		Blog theBlogs = blogService.findById(theId);
		theBlogs.setComments(commentService.findAllByBlog(theBlogs));
		theModel.addAttribute("blog", theBlogs);
		return "user-blog";
		
	}
	@GetMapping("/category")
	public String category(@RequestParam("blogId") int theId, Model theModel) {
		Blog theBlog = blogService.findById(theId);
		theBlog.setComments(commentService.findAllByBlog(theBlog));
		theModel.addAttribute("blog",theBlog);
		return "user-blog";
	}
}

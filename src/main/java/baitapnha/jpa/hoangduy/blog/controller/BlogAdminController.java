package baitapnha.jpa.hoangduy.blog.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import baitapnha.jpa.hoangduy.blog.entity.Blog;
import baitapnha.jpa.hoangduy.blog.entity.Category;
import baitapnha.jpa.hoangduy.blog.entity.Comment;
import baitapnha.jpa.hoangduy.blog.entity.TagName;
import baitapnha.jpa.hoangduy.blog.service.BlogServiceImpl;
import baitapnha.jpa.hoangduy.blog.service.CategoryServiceImpl;
import baitapnha.jpa.hoangduy.blog.service.CommentServiceImpl;
import baitapnha.jpa.hoangduy.blog.service.TagnameServiceImpl;
import baitapnha.jpa.hoangduy.blog.service.define.BaseService;
import baitapnha.jpa.hoangduy.blog.service.define.PageService;

@Controller
@RequestMapping("/blogadmin")
public class BlogAdminController {

	@Autowired
	ServletContext context;
	
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
//	@InitBinder
//	   public void initBinder(WebDataBinder dataBinder) {
//	       Object target = dataBinder.getTarget();
//	       if (target == null) {
//	           return;
//	       }
//	       System.out.println("Target=" + target);
//
//	       if (target.getClass() == Blog.class) {
//	 
//	           // Đăng ký để chuyển đổi giữa các đối tượng multipart thành byte[]
//	           dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
//	       }
//	   }
	@GetMapping("/page")
	public String listblogs( Pageable pageable,  Model theModel) {
		Page<Blog> blogs;
//		if (s.isPresent()) {
//			blogs = blogService.findAllByFirstNameContaining(s.get(), pageable);
//		} else {
		
			blogs = blogService.findAll(pageable);
			for(Blog each : blogs) {
				each.setComments(commentService.findAllByBlog(each));
			}
//		}
		theModel.addAttribute("blogs", blogs);

		return "blog-list";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		// LOG.debug("inside show customer-form handler method");
		Blog theBlog = new Blog();
		theModel.addAttribute("blog", theBlog);

		return "blog-form";
	}
	
	@PostMapping("/saveBlog")
	public String saveCustomer(@RequestParam("file") MultipartFile image,@ModelAttribute("blog") Blog theBlog) {
		  try {
			 
			  theBlog.setImage(image.getOriginalFilename());
	
			  blogService.save(theBlog);
		      MultipartFile multipartFile = image;
		      String fileName = multipartFile.getOriginalFilename();
		      File file = new File(context.getRealPath("resources/images"), fileName);
//		      File file = new File("C:\\Users\\ASUS\\eclipse-workspace\\blog\\src\\main\\webapp\\resources\\images", fileName);
		      multipartFile.transferTo(file);
		      return "redirect:/blogadmin/page";
		    } catch (Exception e) {
		      e.printStackTrace();
		      return "blog-form";
		    }	
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("blogId") int theId, Model theModel) {
		Blog theBlog = blogService.findById(theId);
		theModel.addAttribute("blog", theBlog);
		return "blog-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("blogId") int theId) {
		blogService.remove(theId);
		return "redirect:/blogadmin/page";
	}

	}
	


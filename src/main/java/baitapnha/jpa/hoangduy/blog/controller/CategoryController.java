package baitapnha.jpa.hoangduy.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import baitapnha.jpa.hoangduy.blog.entity.Category;
import baitapnha.jpa.hoangduy.blog.service.define.BaseService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private BaseService<Category> categoryService;

	@GetMapping("/list")
	public String listCategorys(Model theModel) {
		List<Category> theCategorys = categoryService.getAll();
		theModel.addAttribute("categorys", theCategorys);
		return "category-list";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		// LOG.debug("inside show Category-form handler method");
		Category theCategory = new Category();
		theModel.addAttribute("category", theCategory);

		return "category-form";
	}

	@PostMapping("/saveCategory")
	public String saveCategory(@Valid @ModelAttribute("category") Category theCategory,
			BindingResult theBindingResult,Model theModel) {
		if (theBindingResult.hasErrors()) {

			return "category-form";
		}

		else {
			List<Category> check = categoryService.getAll();
			categoryService.save(theCategory);
			return "redirect:/category/list";
		}
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("categoryId") int theId, Model theModel) {
		Category theCategory = categoryService.getByID(theId);
		theModel.addAttribute("category", theCategory);
		return "category-form";
	}

	@GetMapping("/delete")
	public String deleteCategory(@RequestParam("categoryId") int theId) {
		categoryService.deleteById(theId);
		return "redirect:/category/list";
	}
}

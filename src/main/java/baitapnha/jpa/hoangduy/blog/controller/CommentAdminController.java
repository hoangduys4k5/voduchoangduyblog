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

import baitapnha.jpa.hoangduy.blog.entity.Comment;
import baitapnha.jpa.hoangduy.blog.service.define.BaseService;

@Controller
@RequestMapping("/comment")
public class CommentAdminController {

	@Autowired
	private BaseService<Comment> commentService;

	@GetMapping("/list")
	public String listcomments(Model theModel) {
		List<Comment> thecomments = commentService.getAll();
		theModel.addAttribute("comments", thecomments);
		return "comment-list";
	}

	

	@PostMapping("/saveComment")
	public String savecomment(@Valid @ModelAttribute("comment") Comment thecomment,
			BindingResult theBindingResult,Model theModel) {
		if (theBindingResult.hasErrors()) {

			return "comment-form";
		}

		else {
			List<Comment> check = commentService.getAll();
			commentService.save(thecomment);
			return "redirect:/comment/list";
		}
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("commentId") int theId, Model theModel) {
		Comment thecomment = commentService.getByID(theId);
		theModel.addAttribute("comment", thecomment);
		return "comment-form";
	}

	@GetMapping("/delete")
	public String deletecomment(@RequestParam("commentId") int theId) {
		commentService.deleteById(theId);
		return "redirect:/comment/list";
	}
}

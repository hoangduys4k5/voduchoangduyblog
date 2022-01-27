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

import baitapnha.jpa.hoangduy.blog.entity.TagName;
import baitapnha.jpa.hoangduy.blog.service.define.BaseService;

@Controller
@RequestMapping("/tagname")
public class TagNameController {
	
	@Autowired
	private BaseService<TagName> tagnameService;

	@GetMapping("/list")
	public String listtagnames(Model theModel) {
		List<TagName> thetagnames = tagnameService.getAll();
		theModel.addAttribute("tagnames", thetagnames);
		return "tagname-list";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		// LOG.debug("inside show tagname-form handler method");
		TagName thetagname = new TagName();
		theModel.addAttribute("tagname", thetagname);

		return "tagname-form";
	}

	@PostMapping("/saveTagname")
	public String savetagname(@Valid @ModelAttribute("tagname") TagName thetagname,
			BindingResult theBindingResult,Model theModel) {
		if (theBindingResult.hasErrors()) {

			return "tagname-form";
		}

		else {
			List<TagName> check = tagnameService.getAll();
			tagnameService.save(thetagname);
			return "redirect:/tagname/list";
		}
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("tagnameId") int theId, Model theModel) {
		TagName thetagname = tagnameService.getByID(theId);
		theModel.addAttribute("tagname", thetagname);
		return "tagname-form";
	}

	@GetMapping("/delete")
	public String deletetagname(@RequestParam("tagnameId") int theId) {
		tagnameService.deleteById(theId);
		return "redirect:/tagname/list";
	}
}
package pl.cms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.cms.repository.CategoryRepository;
import pl.cms.entity.Category;

@Controller
@RequestMapping("/categories")

public class CategoryController {

	@Autowired
	CategoryRepository categoryRespository;

	@GetMapping("")
	public String showCategories(Model m) {
		m.addAttribute("categories", categoryRespository.findAll());
		return "/category/categories";

	}

	@GetMapping("/add")
	public String addCategories(Model m) {
		m.addAttribute("category", new Category());
		return "/category/addCategory";

	}

	@PostMapping("/add")
	public String addCategories(@Valid @ModelAttribute Category category, BindingResult br) {
		if (br.hasErrors()) {
			return "/category/addCategory";
		}
		categoryRespository.save(category);
		return "redirect:/categories";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		categoryRespository.delete(id);
		return "redirect:/categories";

	}

	@GetMapping("/edit/{id}")
	public String edit(Model m, @PathVariable long id) {
		m.addAttribute("category", categoryRespository.findOne(id));
		return "/category/addCategory";

	}

	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute Category category, BindingResult br) {
		if (br.hasErrors()) {
			return "/category/addCategory";
		}
		categoryRespository.save(category);
		return "redirect:/categories";
	}

}

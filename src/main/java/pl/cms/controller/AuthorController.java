package pl.cms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.cms.entity.Author;
import pl.cms.repository.AuthorRepository;

@Controller
@RequestMapping("/authors")

public class AuthorController {

	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	Author author;

	@GetMapping("/list")
	public String showCategories(Model m) {
		m.addAttribute("authors", authorRepository.findAll());
		return "/author/authors";

	}

	@GetMapping("/add")
	public String addCategories(Model m) {
		m.addAttribute("authors", new Author());
		return "/author/addAuthor";

	}

	@PostMapping("add")
	public String addCategoriesPost(@Valid @ModelAttribute Author author, BindingResult br) {
		if (br.hasErrors()) {
			return "/author/addAuthor";
		}
		authorRepository.save(author);
		return "redirect:/authors";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		authorRepository.delete(id);
		return "redirect:/authors";

	}

	@GetMapping("/edit/{id}")
	public String edit(Model m, @PathVariable long id) {
		m.addAttribute("category", authorRepository.findOne(id));
		return null;

	}

	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute Author author, BindingResult br) {
		if (br.hasErrors()) {
			return "/author/addAuthor";
		}
		authorRepository.save(author);
		return "redirect:/authors";
	}

}

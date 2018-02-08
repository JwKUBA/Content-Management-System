package pl.cms.controller;

import java.util.List;

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

import pl.cms.entity.Article;
import pl.cms.entity.Author;
import pl.cms.entity.Category;
import pl.cms.repository.ArticleRepository;
import pl.cms.repository.AuthorRepository;
import pl.cms.repository.CategoryRepository;


@Controller
@RequestMapping("/articles")

public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	AuthorRepository authorRepository;
	

	@GetMapping("")
	public String showCategories(Model m) {
		m.addAttribute("articlesAll", articleRepository.findAll());
		return "/article/articles";

	}

	@GetMapping("/add")
	public String add(Model m) {
		m.addAttribute("article", new Article());
		return "/article/addArticle";
	}

	@PostMapping("/add")
	public String add(@Valid @ModelAttribute Article article, BindingResult br) {
		if (br.hasErrors()) {
			return "/article/addArticle";
		}
		articleRepository.save(article);
		return "redirect:/articles";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		articleRepository.delete(id);
		return "redirect:/articles";

	}

	@GetMapping("/edit/{id}")
	public String edit(Model m, @PathVariable long id) {
		m.addAttribute("article", articleRepository.findOne(id));
		return "/article/addArticle";

	}

	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute Article article, BindingResult br) {
		if (br.hasErrors()) {
			return "/article/addArticle";
		}
		articleRepository.save(article);
		return "redirect:/articles";
	}

	@ModelAttribute("authors")
	public List<Author> getAuthors() {
		return this.authorRepository.findAll();
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return this.categoryRepository.findAll();
	}

}

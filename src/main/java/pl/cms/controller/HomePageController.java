package pl.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.cms.repository.ArticleRepository;
import pl.cms.repository.CategoryRepository;




@Controller
@RequestMapping("")
public class HomePageController {

	 public final int top = 5;
	
	@Autowired
	 ArticleRepository articlesRepository;
	@Autowired
	CategoryRepository categoryRepository; 
	
	@GetMapping("")
	public String addArticles (Model m) {
		m.addAttribute("lastArticles", articlesRepository.findLast(top));//5 last articles
		m.addAttribute("allCategories",categoryRepository.findAll());
		return "home";
		
		
	}
	
	@PostMapping("")
	public String showCategory(Model m, @RequestParam long categoryId) {
		m.addAttribute("category", categoryRepository.findOne(categoryId));
		m.addAttribute("categoryArticles", articlesRepository.findByCategoriesId(categoryId));
		return "/category/category";
	}
		
		
	}
	
	


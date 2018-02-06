package pl.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.cms.repository.ArticleRepository;
import pl.cms.repository.CategoryRepository;




@Controller
@RequestMapping("/home")
public class HomePageController {

	 public final int top = 5;
	
	@Autowired
	 ArticleRepository articlesRepository;
	@Autowired
	CategoryRepository categoryRepository; 
	
	@GetMapping("/add")
	public String addArticles (Model m) {
		m.addAttribute("lastArticles", articlesRepository.findLast(top));//5 last articles
		m.addAttribute("allCategories",categoryRepository.findAll());
		return "home";
		
		
	}
	
	@PostMapping("/add")
	public String showCategory (Model m, @RequestParam long id) {
		m.addAttribute("category",categoryRepository.findOne(id));//motocykle
		m.addAttribute("articles", articlesRepository.findByCategoriesId(id));
		
		return "/category/category";
		
		
	}
	
	
}

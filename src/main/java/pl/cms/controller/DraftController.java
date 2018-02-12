package pl.cms.controller;



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

import pl.cms.entity.Article;
import pl.cms.repository.ArticleRepository;
import pl.cms.validator.DraftValidationGroup;


@Controller
@RequestMapping("/drafts")

public class DraftController {

	@Autowired
	ArticleRepository articleRepository;

	

	@GetMapping("")
	public String showCategories(Model m) {
		m.addAttribute("draftAll", articleRepository.findByDraftEquals(true));
		return "/draft/drafts";

	}

	@GetMapping("/add")
	public String add(Model m) {
		m.addAttribute("article", new Article());
		return "/draft/addDraft";
	}

	@PostMapping("/add")
	public String add(@Validated(DraftValidationGroup.class) @ModelAttribute Article article, BindingResult br) {
		
		if (br.hasErrors()) {
			return "/draft/addDraft";
		}
		articleRepository.save(article);
		return "redirect:/drafts";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		articleRepository.delete(id);
		return "redirect:/drafts";

	}

	@GetMapping("/edit/{id}")
	public String edit(Model m, @PathVariable long id) {
		m.addAttribute("article", articleRepository.findOne(id));
		return "/draft/addDraft";

	}

	@PostMapping("/edit/{id}")
	public String edit(@Validated(DraftValidationGroup.class) @ModelAttribute Article article, BindingResult br) {
		
		if (br.hasErrors()) {
			return  "/draft/addDraft";
		}
		articleRepository.save(article);
		return "redirect:/drafts";
	}

	

}

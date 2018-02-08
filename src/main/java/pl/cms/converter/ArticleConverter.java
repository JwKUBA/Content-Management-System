package pl.cms.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.cms.entity.Article;

import pl.cms.repository.ArticleRepository;
import pl.cms.repository.CategoryRepository;

public class ArticleConverter implements Converter<String, Article> {

	@Autowired
	private ArticleRepository atricleRepository;

	@Override
	public Article convert(String source) {
		return atricleRepository.findOne(Long.parseLong(source));
	}
}
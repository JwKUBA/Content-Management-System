package pl.cms.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.cms.entity.Category;
import pl.cms.repository.CategoryRepository;

public class CategoryConverter implements Converter<String, Category> {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category convert(String source) {
		return categoryRepository.findOne(Long.parseLong(source));
	}
}
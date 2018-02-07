package pl.cms.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.cms.entity.Author;
import pl.cms.repository.AuthorRepository;

public class AuthorConverter implements Converter<String, Author> {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author convert(String source) {
		return authorRepository.findOne(Long.parseLong(source));
	}
}
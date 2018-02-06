package pl.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.cms.entity.Article;



public interface ArticleRepository extends JpaRepository<Article,Long> {
	
	@Query(value = "SELECT * FROM articles ORDER BY created DESC LIMIT ?1", nativeQuery = true)
	public List<Article> findLast(int top);

	public List<Article> findByCategoriesId(long id);

}
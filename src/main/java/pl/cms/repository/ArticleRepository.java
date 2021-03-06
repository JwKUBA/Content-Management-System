package pl.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.cms.entity.Article;



public interface ArticleRepository extends JpaRepository<Article,Long> {
	
	@Query(value = "SELECT * FROM articles WHERE draft=0 ORDER BY created DESC LIMIT ?1", nativeQuery = true)
	public List<Article> findLast(int top);
	
	@Query(value = "SELECT * FROM articles WHERE draft=0 ", nativeQuery = true)
	public List<Article> findALL();

	public List<Article> findByCategoriesId(long id);
	
	public List<Article> findByDraftEquals( boolean draft);
}

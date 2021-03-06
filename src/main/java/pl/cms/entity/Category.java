package pl.cms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Size(max= 25 , min=5)
	private String name;
	@Column(nullable=true)
	private String description;
	
	@ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER )
	private List<Article> articles;
	
	
	public Category() {
		super();
		
	}

	public Category(String name, String description, List<Article> articles) {
		super();
		this.name = name;
		this.description = description;
		this.articles = articles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	


}

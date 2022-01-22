package baitapnha.jpa.hoangduy.blog.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="blogs")
public class Blog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@Column(name="image")
	private String image;
	
	@OneToMany(mappedBy = "blog")
    private List<Comment> comments;
	
	@ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
	
	@Column(name="likes")
	private int like;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "Blogs_TagNames",
	        joinColumns = @JoinColumn(name = "Blog_Id"),
	        inverseJoinColumns = @JoinColumn(name = "TagName_Id")
	    )
	private List<TagName> tagnames = new ArrayList();
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public List<TagName> getTagnames() {
		return tagnames;
	}

	public void setTagnames(List<TagName> tagnames) {
		this.tagnames = tagnames;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	
	public Blog(int id, String title, String content, String image, List<Comment> comments, int like,
			List<TagName> tagnames, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.image = image;
		this.comments = comments;
		this.like = like;
		this.tagnames = tagnames;
		this.category = category;
	}

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

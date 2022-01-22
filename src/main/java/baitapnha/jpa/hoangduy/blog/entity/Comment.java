package baitapnha.jpa.hoangduy.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="cmt")
	private String cmt;
	
	@ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Comment(int id, String cmt, Blog blog) {
		super();
		this.id = id;
		this.cmt = cmt;
		this.blog = blog;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

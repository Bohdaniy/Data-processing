package lab5.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "post2")
public class Post2 {
 
    @Id
    @GeneratedValue
    private Long id;
 
    private String title;
 
    @OneToMany(
    	mappedBy="post",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )    
    private List<PostComment2> comments = new ArrayList<>();

	public Post2() {
	}
	
	public Post2(String title) {
		this.title=title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<PostComment2> getComments() {
		return comments;
	}

	public void setComments(List<PostComment2> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + "]";
	}
	
	
 
    
}
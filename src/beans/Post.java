package beans;

import java.io.Serializable;

public class Post implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;

	private String title;
	private String content;
	private String imagePath;
	private String createdTime;
	
	public Post(int id,String title,String content,String imagePath,String createdTime) {
		setId(id);
		setTitle(title);
		setContent(content);
		setImagePath(imagePath);
		setCreatedTime(createdTime);
	}
	
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
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
}

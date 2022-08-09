package com.codingdojo.bookclub.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
    
	// ----- variables -----
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Title is required!")
    @Size(min=1)
    private String title;
    
    @NotEmpty(message="Author is required!")
    @Size(min=1)
    private String author;
    
    @NotEmpty(message="Tell us what you thought!")
    @Size(min=1)
    private String myThoughts;
    
    // this is going to be the users name for oneBook.js
    
	private Date createdAt;

	private Date updatedAt;
	
	// creating many to one relationship with user
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="users_id")
    private User user;
  
	// ----- Constructors -----
	
	public Book() {}

	public Book(@NotEmpty(message = "Title is required!") @Size(min = 1) String title,
			@NotEmpty(message = "Author is required!") @Size(min = 1) String author,
			@NotEmpty(message = "Tell us what you thought!") @Size(min = 1) String myThoughts, User user) {
		super();
		this.title = title;
		this.author = author;
		this.myThoughts = myThoughts;
		this.user = user;
	}

	public Book(Long id, @NotEmpty(message = "Title is required!") @Size(min = 1) String title,
			@NotEmpty(message = "Author is required!") @Size(min = 1) String author,
			@NotEmpty(message = "Tell us what you thought!") @Size(min = 1) String myThoughts, Date createdAt,
			Date updatedAt, User user) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.myThoughts = myThoughts;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}

	// ----- Getters and Setters -----
	
	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMyThoughts() {
		return myThoughts;
	}

	public void setMyThoughts(String myThoughts) {
		this.myThoughts = myThoughts;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	// ----- Created At and Updated At -----
	
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}

	@PreUpdate
     protected void onUpdate(){
         this.updatedAt = new Date();
     }
}

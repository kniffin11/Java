package com.codingdojo.javabeltexam.models;

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
@Table(name="joyBundlers")
public class JoyBundler {

	// ----- Variables -----
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Name cant be empty!")
    @Size(min=2, message="Name must be at least 2 characters")
    private String name;
    
    @NotEmpty(message="Gender cant be empty!")
    @Size(min=1, message="Gender must be not be empty!")
    private String gender;
    
    @NotEmpty(message="Origin cant be empty!")
    @Size(min=1, message="Origin must be not be empty!")
    private String origin;
    
    @NotEmpty(message="Whats the meaning behind the name?")
    @Size(min=1, message="Meaning must be not be empty!")
    private String meaning;
    
    private Date createdAt;

	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="users_id")
    private User user;
		
	// ----- Constructors -----
	
	public JoyBundler() {}
	
	public JoyBundler(
			@NotEmpty(message = "Name cant be empty!") @Size(min = 2, message = "Name must be at least 2 characters") String name,
			@NotEmpty(message = "Gender cant be empty!") @Size(min = 1) String gender,
			@NotEmpty(message = "Origin cant be empty!") @Size(min = 1) String origin,
			@NotEmpty(message = "Whats the meaning behind the name?") @Size(min = 1) String meaning, User user) {
		super();
		this.name = name;
		this.gender = gender;
		this.origin = origin;
		this.meaning = meaning;
		this.user = user;
	}
	
	public JoyBundler(Long id,
			@NotEmpty(message = "Name cant be empty!") @Size(min = 2, message = "Name must be at least 2 characters") String name,
			@NotEmpty(message = "Gender cant be empty!") @Size(min = 1) String gender,
			@NotEmpty(message = "Origin cant be empty!") @Size(min = 1) String origin,
			@NotEmpty(message = "Whats the meaning behind the name?") @Size(min = 1) String meaning, Date createdAt,
			Date updatedAt, User user) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.origin = origin;
		this.meaning = meaning;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}

	// ----- Getters and Setters -----
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	// ----- Created and Updated at -----

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
     protected void onUpdate(){
         this.updatedAt = new Date();
     }
}

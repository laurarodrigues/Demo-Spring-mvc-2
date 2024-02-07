package com.example.collectibles.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class User_ {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Date of birth cannot be empty")
	@Past(message = "Date of birth cannot be a future date")
	private Date date_of_birth;
	
	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Should be a well-formed email address")
	private String email;
	
	@NotEmpty(message = "Select at least one favorite character")
	private String favorite_collection;
	
	@NotEmpty(message = "Gender cannot be empty")
	private String gender;
	private String message_;
	
	@NotEmpty(message = "Name cannot be empty")
	@Size(min = 1, max = 20, message = "Size must be between 1 and 20")
	private String name_;
	private boolean news_letter;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFavorite_collection() {
		return favorite_collection;
	}
	public void setFavorite_collection(String favorite_collection) {
		this.favorite_collection = favorite_collection;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMessage_() {
		return message_;
	}
	public void setMessage_(String message_) {
		this.message_ = message_;
	}
	public String getName_() {
		return name_;
	}
	public void setName_(String name_) {
		this.name_ = name_;
	}
	public boolean isNews_letter() {
		return news_letter;
	}
	public void setNews_letter(boolean news_letter) {
		this.news_letter = news_letter;
	}
	
	
	

}

package com.example.collectibles.beans;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Product {
	
	@Id
	private int id;
	
	private String name;
	private String description;
	private int rating;
	private int no_of_reviews;
	private String color;
	

	private int category_id;
	private int robot_id;
	private String image_path;
	private int price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getNoOfReviews() {
		return no_of_reviews;
	}
	public void setNoOfReviews(int noOfReviews) {
		this.no_of_reviews = noOfReviews;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getRobotID() {
		return robot_id;
	}
	public void setRobotID(int robotID) {
		this.robot_id = robotID;
	}
	public String getImagePath() {
		return image_path;
	}
	public void setImagePath(String imagePath) {
		this.image_path = imagePath;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}

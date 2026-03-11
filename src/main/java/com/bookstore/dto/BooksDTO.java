package com.bookstore.dto;

public class BooksDTO {

	private int id;
	private String title;
	private String author;
	private String category;
	private Double price;
	private String image;
	private String description;
	
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public BooksDTO(int id, String title, String author, String category, Double price, String image,
			String description) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.image = image;
		this.description = description;
	}
	
	public BooksDTO(String title, String author, String category, Double price, String image,
			String description) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.image = image;
		this.description = description;
	}

	public BooksDTO() {}
}

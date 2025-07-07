package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "records")
public class Kakei {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;

	private Date date;

	@Column(name = "categoy_id")
	private Integer categoryId;

	private String title;

	private String detail;

	private Integer price;

	public Kakei(Integer userId, Date date,
			Integer categoryId, String title, String detail,
			Integer price) {
		this.userId = userId;
		this.date = date;
		this.categoryId = categoryId;
		this.title = title;
		this.detail = detail;
		this.price = price;
	}

	public Kakei() {

	}

	public Integer getId() {
		return id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public String getTitle() {
		return title;
	}

	public String getDetail() {
		return detail;
	}

	public Integer getPrice() {
		return price;
	}
}

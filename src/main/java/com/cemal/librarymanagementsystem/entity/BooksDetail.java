package com.cemal.librarymanagementsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BooksDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long detail_id;
	@Column(name = "page_number")
	private int pageNumber;
	@Column(name = "summary")
	private String summary;
	@Column(name = "comments")
	private String comments;
	@Column(name = "about_author")
	private String abaoutAuthor;
	
}

package com.cemal.librarymanagementsystem.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "book_name", length = 20, unique = false)
	private String bookName;
	@Column(name = "author", length = 20, unique = false)
	private String author;
	@Column(name = "price")
	private int price;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "detail_id")
	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	private BooksDetail detail_id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "publish_date")
	private Date publishDate;

	
	
	

}

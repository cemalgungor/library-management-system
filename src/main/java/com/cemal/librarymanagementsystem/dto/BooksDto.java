package com.cemal.librarymanagementsystem.dto;

import java.util.Date;

import com.cemal.librarymanagementsystem.entity.BooksDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksDto {
	private Long id;
	private String bookName;
	private String author;
	private int price;
	private BooksDetail detail_id;
	private Date publishDate;
}

package com.cemal.librarymanagementsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cemal.librarymanagementsystem.dto.BooksDto;
import com.cemal.librarymanagementsystem.entity.Books;
import com.cemal.librarymanagementsystem.service.impl.BookServiceImpl;
import com.cemal.librarymanagementsystem.util.TPage;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookController {
	
	private final BookServiceImpl bookServiceImpl;
	private final ModelMapper modelMapper;
	
	public BookController(BookServiceImpl bookServiceImpl, ModelMapper modelMapper) {

		this.bookServiceImpl = bookServiceImpl;
		this.modelMapper = modelMapper;
	}

	@GetMapping("/book")
	public ResponseEntity<TPage<BooksDto>> getAllBooks(Pageable pageable) {
		TPage<BooksDto> data = bookServiceImpl.getAllPageable(pageable);
		return ResponseEntity.ok(data);
	}

	@PostMapping
	public ResponseEntity<Books> addBooks(@Valid @RequestBody Books book) {

		return ResponseEntity.ok(bookServiceImpl.addBook(book));
	}

	@PutMapping
	public ResponseEntity<Books> uptadePrice(@Valid @RequestBody Books book) {

		return ResponseEntity.ok(bookServiceImpl.updateBook(book));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteBooks(@PathVariable(value = "id", required = true) Long id) {

		return ResponseEntity.ok(bookServiceImpl.deleteBook(id));
	}

}

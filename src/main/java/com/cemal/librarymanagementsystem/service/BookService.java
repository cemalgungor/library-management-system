package com.cemal.librarymanagementsystem.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cemal.librarymanagementsystem.dto.BooksDto;
import com.cemal.librarymanagementsystem.entity.Books;
import com.cemal.librarymanagementsystem.util.TPage;



public interface BookService {
	 List<Books> getAllBooks();
     Books addBook(Books book);
     Books updateBook( Books book);
     Boolean deleteBook(Long id);

     TPage<BooksDto> getAllPageable(Pageable pageable);

}

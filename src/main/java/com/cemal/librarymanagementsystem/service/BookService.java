package com.cemal.librarymanagementsystem.service;

import java.util.List;



import com.cemal.librarymanagementsystem.entity.Books;


public interface BookService {
	 List<Books> getAllBooks();
     Books addBook(Books book);
     Books updateBook( Books book);
     Boolean deleteBook(Long id);
     

}

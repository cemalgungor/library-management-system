package com.cemal.librarymanagementsystem.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cemal.librarymanagementsystem.dto.BooksDto;
import com.cemal.librarymanagementsystem.entity.Books;
import com.cemal.librarymanagementsystem.entity.BooksDetail;
import com.cemal.librarymanagementsystem.repository.BookRepository;
import com.cemal.librarymanagementsystem.repository.BooksDetailRepository;
import com.cemal.librarymanagementsystem.service.BookService;
import com.cemal.librarymanagementsystem.util.TPage;


@Service
public class BookServiceImpl implements BookService {
	
	private final  BookRepository bookRepo;
	@Autowired
	ModelMapper modelMapper;

	private final  BooksDetailRepository booksDetailRepo;
	public BookServiceImpl(BookRepository bookRepo, BooksDetailRepository booksDetailRepo) {
	
		this.bookRepo = bookRepo;
	
		this.booksDetailRepo = booksDetailRepo;
	}

 


	@Override
	public List<Books> getAllBooks() {

		return bookRepo.findAll();
	}

	@Override
	public Books addBook(Books book) {
        
		BooksDetail booksDetail= new BooksDetail();
	
		booksDetail.setAbaoutAuthor(book.getDetail_id().getAbaoutAuthor());   
		booksDetail.setComments(book.getDetail_id().getComments());
		booksDetail.setPageNumber(book.getDetail_id().getPageNumber());
		booksDetail.setSummary(book.getDetail_id().getSummary());
		//bookEntity.setDetail_id(booksDetailRepo.getOne(book.getDetail_id()));
	    booksDetailRepo.save(booksDetail);
	    return bookRepo.save(book);
	}

	@Override
	public Books updateBook(Books book) {
		Books bookEntity = new Books();
		bookEntity.setPrice(book.getPrice());
		return bookRepo.save(bookEntity);
	}

	@Override
	public Boolean deleteBook(Long id) {
		bookRepo.deleteById(id);
		if (bookRepo.findById(id).equals(id) ) {

			return false;
		}
		return true;
	}

	@Override
	public TPage<BooksDto> getAllPageable(Pageable pageable) {
		 Page<Books> data=bookRepo.findAll(pageable);
		 TPage<BooksDto> response= new TPage<BooksDto>();
		 response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), BooksDto[].class)));
		return response;
	}

}

package com.example.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;

@Service
public class BookService {
	
	private final BookRepository brepo;
	
	
	  public BookService(BookRepository brepo) {
	        this.brepo = brepo;
	    }
	
	public void save(Book b) {
		brepo.save(b);
	}

		public List<Book> getAllBooks(){
			return brepo.findAll();

			
		}
		public void deleteBookById(Long id) {
		    brepo.deleteById(id);
		}
		public Book getBookById(Long id) {
		    return brepo.findById(id).orElse(null);
		}


}

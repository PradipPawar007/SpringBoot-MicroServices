package com.in.pradip.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in.pradip.binding.Book;

@RestController
public class BookRestController {

	
	
	@PostMapping(
			    value = "book",
			    consumes = {" application/xml "," application/json "}			    
			)
	public ResponseEntity<String> addBook(@RequestBody Book book){
		System.out.println(book);
		String msg = "Book Data Saved Sccessfully...!";
		//Save Book Logic
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	
	@GetMapping(
			value = "/book",
			produces = {" application/xml "," application/json "}
		)
	public Book getBook() {
		Book b = new Book();
		b.setId(101);
		b.setName("Java");
		b.setPrice(445.00);
		return b;
	}
}

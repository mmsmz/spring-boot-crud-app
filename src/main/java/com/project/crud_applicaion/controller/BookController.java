package com.project.crud_applicaion.controller;


import com.project.crud_applicaion.model.BookRequest;
import com.project.crud_applicaion.model.BookResponse;
import com.project.crud_applicaion.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/allBooks")
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<BookResponse> listOfFBooksResponses = service.getListOfBooks();
        if (listOfFBooksResponses.isEmpty()){
            return ResponseEntity.noContent().build(); // 204 No content
        }
        return new ResponseEntity<>(listOfFBooksResponses, HttpStatus.OK); // 200 ok
    }

    @PostMapping("/books")
    public ResponseEntity<String> addBook(@RequestBody BookRequest bookRequest) {
        String status = service.addBookDetails(bookRequest);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable(name = "id") Long studentId) {
        BookResponse bookDetails = service.getBookById(studentId);
        return new ResponseEntity<>(bookDetails, HttpStatus.OK);
    }

    @PutMapping("/book")
    public ResponseEntity<String> getUpdateBookById(@RequestBody BookRequest bookRequest) {
        String bookDetails = service.getUpdateBookById(bookRequest);
        return new ResponseEntity<>(bookDetails, HttpStatus.OK);
    }

//    @DeleteMapping
//    public void deleteBookById() {
//
//    }

}

package com.project.crud_applicaion.service;

import com.project.crud_applicaion.model.BookRequest;
import com.project.crud_applicaion.model.BookResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> getListOfBooks();

    String addBookDetails(BookRequest bookRequest);

    BookResponse getBookById(Long studentId);

    String getUpdateBookById(BookRequest studentId);


}

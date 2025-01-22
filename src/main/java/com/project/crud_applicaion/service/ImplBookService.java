package com.project.crud_applicaion.service;

import com.project.crud_applicaion.entity.BookEntity;
import com.project.crud_applicaion.model.BookRequest;
import com.project.crud_applicaion.model.BookResponse;
import com.project.crud_applicaion.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ImplBookService implements BookService {
    @Autowired
    BookRepo bookRepo;

    @Override
    public List<BookResponse> getListOfBooks() {
        List<BookResponse> bookResponseList = new ArrayList<>();
        List<BookEntity> entityBook = bookRepo.findAll();
        if (!entityBook.isEmpty()) {
            entityBook.forEach(book -> {
                BookResponse bookResponse = new BookResponse();
                bookResponse.setId(book.getId());
                bookResponse.setTitle(book.getAuthor());
                bookResponse.setAuthor(book.getAuthor());
                bookResponseList.add(bookResponse);
            });
            return bookResponseList;
        }
        return bookResponseList;
    }

    @Override
    public String addBookDetails(BookRequest bookRequest) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor(bookRequest.getAuthor());
        bookEntity.setTitle(bookRequest.getTitle());
        BookEntity save = bookRepo.save(bookEntity);
        if (!Objects.isNull(save.getId())) {
            return "Successfully Save";
        } else
            return "No Content Found";
    }

    @Override
    public BookResponse getBookById(Long studentId) {
        BookResponse bookResponse = new BookResponse();
        Optional<BookEntity> byId = bookRepo.findById(studentId);
        byId.stream().forEach(map -> {
            bookResponse.setAuthor(map.getAuthor());
            bookResponse.setTitle(map.getTitle());
            bookResponse.setId(map.getId());
        });
        return bookResponse;
    }

    @Override
    public String getUpdateBookById(BookRequest studentId) {

        Optional<BookEntity> bookEntity = bookRepo.findById(studentId.getId());
        if(bookEntity.isPresent()){
            BookEntity bookEntity1 = bookEntity.get();
            bookEntity1.setAuthor(studentId.getAuthor());
            bookEntity1.setTitle(studentId.getTitle());
            bookRepo.save(bookEntity1);
            return "Successfully Updated";
        }else
            return "No data Saved";

    }


}

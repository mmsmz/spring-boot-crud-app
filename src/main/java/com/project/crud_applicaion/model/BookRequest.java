package com.project.crud_applicaion.model;

public class BookRequest {

    private Long id;
    private String title;

    private String author;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

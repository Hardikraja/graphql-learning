package com.graphql.learn.service;

import com.graphql.learn.entity.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    List<Book> getAll();

    Book get(int id);
}

package com.graphql.learn.impl;

import com.graphql.learn.entity.Book;
import com.graphql.learn.repository.BookRepository;
import com.graphql.learn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book get(int id) {
        return this.bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }
}

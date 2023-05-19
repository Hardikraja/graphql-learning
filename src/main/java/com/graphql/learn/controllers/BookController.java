package com.graphql.learn.controllers;

import com.graphql.learn.entity.Book;
import com.graphql.learn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book/create")
    public Book create(@RequestBody Book book){
        return this.bookService.create(book);
    }

    @GetMapping("/books")
    public List<Book> getAll(){
        return this.bookService.getAll();
    }

    @GetMapping("/book/id/{bookId}")
    public Book get(@PathVariable Integer bookId){
        return this.bookService.get(bookId);
    }



}

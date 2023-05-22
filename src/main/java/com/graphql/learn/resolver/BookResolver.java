package com.graphql.learn.resolver;

import com.graphql.learn.entity.Book;
import com.graphql.learn.service.BookService;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookResolver  {

    @Autowired
    private BookService bookService;


    @GraphQLQuery
    public List<Book> books(){
        return bookService.getAll();
    }


}

package com.graphql.learn.resolver;

import com.graphql.learn.entity.Book;
import com.graphql.learn.service.BookService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.jws.Oneway;
import java.util.List;

@DgsComponent
@Controller
public class BookResolver {

    @Autowired
    private BookService bookService;

    @DgsQuery
    public List<Book> books(){
        return bookService.getAll();
    }


}

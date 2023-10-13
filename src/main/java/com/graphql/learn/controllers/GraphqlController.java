package com.graphql.learn.controllers;

import com.graphql.learn.resolver.BookResolver;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphQLException;
import graphql.execution.AsyncExecutionStrategy;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class GraphqlController {

    private final GraphQL graphQL;

    @Autowired
    public GraphqlController(BookResolver bookResolver) {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withBasePackages("com.graphql.learn")
                .withOperationsFromSingleton(bookResolver)
                .generate();
        this.graphQL = new GraphQL.Builder(schema)
                .queryExecutionStrategy(new AsyncExecutionStrategy(new CustomExceptionHandler()))
                .mutationExecutionStrategy(new AsyncExecutionStrategy(new CustomExceptionHandler()))
                .build();
    }

    @PostMapping(value = "/graphql")
    public Map<String, Object> execute(@RequestBody Map<String, String> request, HttpServletRequest raw)
            throws GraphQLException {
        ExecutionResult result = graphQL.execute(request.get("query"));
        return result.getData();
    }
}
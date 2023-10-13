package com.graphql.learn.controllers;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.DataFetcherExceptionHandlerResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class CustomExceptionHandler implements DataFetcherExceptionHandler {

    private DataFetcherExceptionHandlerResult onExceptionHandler(DataFetcherExceptionHandlerParameters handlerParameters) {

        Throwable exception = handlerParameters.getException();

        // do something with exception

        GraphQLError error = GraphqlErrorBuilder
                .newError()
                .message(exception.getMessage())
                .build();

        return DataFetcherExceptionHandlerResult
                .newResult()
                .error(error)
                .build();
    }

    @Override
    public CompletableFuture<DataFetcherExceptionHandlerResult> handleException(DataFetcherExceptionHandlerParameters handlerParameters) {
        DataFetcherExceptionHandlerResult result = onExceptionHandler(handlerParameters);
        return CompletableFuture.completedFuture(result);
    }
}

package com.multimedia.joinedpawsong.api.common.handler;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.multimedia.joinedpawsong.api.common.dtos.ErroResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestControllerAdvice
public class ApiExceptionHandller extends ResponseEntityExceptionHandler {

    private final PropertyNamingStrategies.SnakeCaseStrategy snakeCaseStrategy = new PropertyNamingStrategies.SnakeCaseStrategy();

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        var body = ErroResponse.builder()
                .status(status.value())
                .error(status.getReasonPhrase())
                .cause(ex.getClass().getSimpleName())
                .message("Houverão erro de validação")
                .timesTamp(LocalDateTime.now())
                .erros(converFieldError(ex.getBindingResult().getFieldErrors()))
                .build();

        return new ResponseEntity<>(body,status);
    }
    private Map<String, List<String>> converFieldError(List<FieldError> fieldErrorList){
        var erros = new HashMap<String,List<String>>();
        fieldErrorList.stream().forEach( fieldError -> {
            var field = snakeCaseStrategy.translate(fieldError.getField());
            if(erros.containsKey(field)){
                erros.get(field).add(fieldError.getDefaultMessage());
            }else{
                erros.put(field,
                        Stream.of(fieldError.getDefaultMessage()).collect(Collectors.toList()));
            }
        });

        return erros;
    }
}

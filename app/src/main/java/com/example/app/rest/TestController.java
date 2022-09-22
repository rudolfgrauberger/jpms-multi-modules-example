package com.example.app.rest;

import com.example.module.api.BookApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private BookApi bookApi;

    @GetMapping( path = "", produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<String>> getAllBooks() {

        return ResponseEntity.ok(bookApi.getAll().stream().map(BookApi.BookDto::getName).collect(Collectors.toList()));
    }
}

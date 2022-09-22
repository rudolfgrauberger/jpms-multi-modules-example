package com.example.module.api;

import com.example.module.entities.*;
import com.example.module.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookApi {

    public class BookDto {
        private String name;

        public String getName() {
            return this.name;
        }

        public BookDto(String name) {
            this.name = name;
        }
    }
    @Autowired
    private BookRepository repository;

    public void addBook(String name) {
        var book = new Book();
        book.setName(name);

        repository.save(book);
    }

    public List<BookDto> getAll() {
        return repository.findAll().stream().map(x -> new BookDto(x.getName())).collect(Collectors.toList());
    }
}

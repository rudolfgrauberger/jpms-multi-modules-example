package com.example.module.entities;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "book_id_seq", allocationSize = 1)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    private Long id;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Book() {
    }

}

package com.example.module.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.module.entities.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

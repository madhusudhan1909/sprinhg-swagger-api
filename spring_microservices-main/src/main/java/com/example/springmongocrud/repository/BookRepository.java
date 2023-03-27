package com.example.springmongocrud.repository;

import com.example.springmongocrud.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {
    List<Book> findAll();
}

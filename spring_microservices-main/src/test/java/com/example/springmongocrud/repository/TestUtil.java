package com.example.springmongocrud.repository;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.springmongocrud.entity.Book;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshul.sample_bird_app.model.Bird;

/**
 * 
 * @author harshul varshney
 * Jun 6, 2017
 */
public class TestUtil {


	public static List<Book> createBirdListForTesting() {
		List<Book> books = new ArrayList<>();
		books.add(new Book("1",1,"book1","author1",1.0));
		books.add(new Book("2",2,"book2","author2",2.0));
		return books;
	}


}
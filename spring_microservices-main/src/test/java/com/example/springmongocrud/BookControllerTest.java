package com.example.springmongocrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.springmongocrud.controller.BookController;
import com.example.springmongocrud.entity.Book;
import com.example.springmongocrud.repository.BookRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BookControllerTest {

    private BookRepository bookRepository;
    private BookController bookController;

    @BeforeEach
    public void setUp() {
        bookRepository = mock(BookRepository.class);
        bookController = new BookController(bookRepository);
    }

    @Test
    public void testSaveBook() {
        Book book = new Book();
        book.setId("1");
        book.setBookName("Java for Dummies");

        ResponseEntity<String> response = bookController.saveBook(book);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Added book with id : 1", response.getBody());
    }

    @Test
    public void testGetBooks() {
        Book book1 = new Book();
        book1.setId("1");
        book1.setBookName("Java for Dummies");

        Book book2 = new Book();
        book2.setId("2");
        book2.setBookName("Clean Code");

        List<Book> books = Arrays.asList(book1, book2);

        when(bookRepository.findAll()).thenReturn(books);

        ResponseEntity<List<Book>> response = bookController.getBooks();

        assertEquals(2, response.getBody().size());
        assertEquals("Java for Dummies", response.getBody().get(0).getBookName());
        assertEquals("Clean Code", response.getBody().get(1).getBookName());
    }

    @Test
    public void testGetBookWithValidId() {
        Book book = new Book();
        book.setId("1");
        book.setBookName("Java for Dummies");

        when(bookRepository.findById("1")).thenReturn(Optional.of(book));

        ResponseEntity<Book> response = bookController.getBook(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Java for Dummies", response.getBody().getBookName());
    }

    @Test
    public void testGetBookWithInvalidId() {
        ResponseEntity<Book> response = bookController.getBook(-1);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testDeleteBookWithValidId() {
        ResponseEntity<String> response = bookController.deleteBook(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Book with id 1 has been deleted", response.getBody());
    }



}

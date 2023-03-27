package com.example.springmongocrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.springmongocrud.entity.Book;
import com.example.springmongocrud.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.MongoRepository;

@SpringBootTest
public class BookRepositoryTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private MongoRepository<Book, String> mongoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book();
        book1.setId("1");
        book1.setBookName("Java for Dummies");
        Book book2 = new Book();
        book2.setId("2");
        book2.setBookName("Clean Code");
        bookList.add(book1);
        bookList.add(book2);
        when(mongoRepository.findAll()).thenReturn(bookList);
        List<Book> result = bookRepository.findAll();
        assertEquals(bookList, result);
    }

    @Test
    public void testFindById() {
        Book book = new Book();
        book.setId("1");
        book.setBookName("Java for Dummies");
        Optional<Book> optionalBook = Optional.of(book);
        when(mongoRepository.findById("1")).thenReturn(optionalBook);
        Optional<Book> result = bookRepository.findById("1");
        assertEquals(optionalBook, result);
    }

    @Test
    public void testSave() {
        Book book = new Book();
        book.setId("1");
        book.setBookName("Java for Dummies");
        when(mongoRepository.save(book)).thenReturn(book);
        Book result = bookRepository.save(book);
        assertEquals(book, result);
    }

    @Test
    public void testDeleteById() {
        String id = "1";
        bookRepository.deleteById(id);
        // verify that mongoRepository.deleteById() was called once with the correct id
        verify(mongoRepository, times(1)).deleteById(id);
    }

}

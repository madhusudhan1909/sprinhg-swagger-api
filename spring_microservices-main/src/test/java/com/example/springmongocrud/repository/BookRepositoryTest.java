package com.example.springmongocrud.repository;

import com.example.springmongocrud.controller.BookController;
import com.example.springmongocrud.entity.Book;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookRepositoryTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    BookController bookController;

        public void testFindAll() {
            List<Book> birds = TestUtil.createBirdListForTesting();
            Mockito.when(bookRepository.findAll()).thenReturn(birds);

            ResponseEntity<List<Book>> findAllResult = bookController.getBooks();
            Assert.(2, findAllResult.getBody().size(););
        }
    }




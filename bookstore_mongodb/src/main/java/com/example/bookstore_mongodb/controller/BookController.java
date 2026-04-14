package com.example.bookstore_mongodb.controller;

import com.example.bookstore_mongodb.entity.Book;
import com.example.bookstore_mongodb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @DeleteMapping("/apibooks/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        Optional<Book> book = book.Repository.findById(id);

        if (book.isPresent()){
            bookRepository.deleteById(id);
            return ResponseEntity.ok("Book deleted succesfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
    }
}

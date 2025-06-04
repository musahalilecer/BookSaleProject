package com.musahalilecer.booksaleproject.controller;

import com.musahalilecer.booksaleproject.dto.request.BookRequest;
import com.musahalilecer.booksaleproject.dto.response.BookResponse;
import com.musahalilecer.booksaleproject.service.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        try {
            if(bookService.getAllBooks().isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            else {
                List<BookResponse> books = bookService.getAllBooks();
                return ResponseEntity.ok(books);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable int id) {
        try{
            if(bookService.getBookById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            else {
                BookResponse book = bookService.getBookById(id);
                return ResponseEntity.ok(book);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest bookRequest) {
        try{
            BookResponse createdBook = bookService.createBook(bookRequest);
            return ResponseEntity.ok(createdBook);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable int id, @RequestBody BookRequest bookRequest) {

        try{
            BookResponse updatedBook = bookService.updateBook(id, bookRequest);
            return ResponseEntity.ok(updatedBook);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        try{
            if(bookService.getBookById(id) == null) {
                System.out.println("Error");
            }
            else {
                bookService.deleteBook(id);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

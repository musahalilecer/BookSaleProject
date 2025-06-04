package com.musahalilecer.booksaleproject.controller;

import com.musahalilecer.booksaleproject.dto.request.AuthorRequest;
import com.musahalilecer.booksaleproject.dto.response.AuthorResponse;
import com.musahalilecer.booksaleproject.service.serviceImp.AuthorServiceImp;
import com.musahalilecer.booksaleproject.service.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorServiceImp authorService;

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable int id) {
        try{
            AuthorResponse author = authorService.getAuthorById(id);
            if(author != null) {
                return ResponseEntity.ok(author);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody AuthorRequest authorRequest) {
        try{
            AuthorResponse newAuthor = authorService.createAuthor(authorRequest);
                return ResponseEntity.ok(newAuthor);
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> updateAuthor(@RequestBody AuthorRequest authorRequest, @PathVariable int id) {
        try{
            AuthorResponse updatedAuthor = authorService.getAuthorById(id);
            if(updatedAuthor != null) {
                updatedAuthor.setName(authorRequest.getName());
                updatedAuthor.setImage(authorRequest.getImage());
                return ResponseEntity.ok(updatedAuthor);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable int id) {
        try{
            authorService.deleteAuthor(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
        /*
        if(authorService.getAuthorById(id) != null) {
            authorService.deleteAuthor(id);
        }
        else {
            System.out.println("Not Found For deleting");
        }

         */
    }
}

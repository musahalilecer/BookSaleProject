package com.musahalilecer.booksaleproject.controller;

import com.musahalilecer.booksaleproject.dto.request.LanguageRequest;
import com.musahalilecer.booksaleproject.dto.response.LanguageResponse;
import com.musahalilecer.booksaleproject.model.Language;
import com.musahalilecer.booksaleproject.service.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<LanguageResponse>> getAllLanguages() {
        try{
            return ResponseEntity.ok(languageService.getAlllanguages());
        }
        catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageResponse> getLanguageById(@PathVariable int id) {
        try{
            LanguageResponse languageResponse = languageService.getlanguageById(id);
            return ResponseEntity.ok(languageResponse);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<LanguageResponse> createLanguage(@RequestBody LanguageRequest languageRequest) {
        try{
            LanguageResponse newLanguage = languageService.createLanguage(languageRequest);
            if(newLanguage != null){
                return ResponseEntity.ok(newLanguage);
            }
            else {
                return ResponseEntity.noContent().build();
            }
        }
        catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    /*
    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable int id) {
        try{
            authorService.deleteAuthor(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
     */
    @DeleteMapping("/{id}")
    public void deleteLanguage(@PathVariable int id) {
        try{
            languageService.deleteLanguage(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

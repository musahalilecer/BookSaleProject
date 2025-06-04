package com.musahalilecer.booksaleproject.controller;

import com.musahalilecer.booksaleproject.dto.request.PublisherRequest;
import com.musahalilecer.booksaleproject.dto.response.PublisherResponse;
import com.musahalilecer.booksaleproject.mapper.PublisherMapper;
import com.musahalilecer.booksaleproject.model.Publisher;
import com.musahalilecer.booksaleproject.repository.PublisherRepository;
import com.musahalilecer.booksaleproject.service.serviceImp.PublisherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherServiceImp publisherService;
    private PublisherRepository publisherRepository;

    @GetMapping
    public ResponseEntity<List<PublisherResponse>> getAllPublishers(){
        try{
             return ResponseEntity.ok(publisherService.getPublishers());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponse> getPublisher(Integer id){
        try{
            PublisherResponse publisher = publisherService.getPublisher(id);
            return ResponseEntity.ok(publisher);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /*
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
         */
    }
    @PostMapping
    public ResponseEntity<PublisherResponse> createPublisher(@RequestBody PublisherRequest publisherRequest){
        try{
            PublisherResponse newPublisher = publisherService.createPublisher(publisherRequest);
            return ResponseEntity.ok(newPublisher);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
    Author newAuthor = AuthorMapper.toAuthorEntity(authorRequest.getName(), authorRequest.getImage());
        Author savedAuthor = authorRepository.save(newAuthor);
        return AuthorMapper.toAuthorResponse(savedAuthor);
     */

    @DeleteMapping("/{id}")
    public void deletePublisher(@PathVariable Integer id){
        try{
            publisherService.deletePublisher(id);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

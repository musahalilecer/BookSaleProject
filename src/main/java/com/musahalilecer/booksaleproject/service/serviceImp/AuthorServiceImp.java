package com.musahalilecer.booksaleproject.service.serviceImp;

import com.musahalilecer.booksaleproject.dto.request.AuthorRequest;
import com.musahalilecer.booksaleproject.dto.response.AuthorResponse;
import com.musahalilecer.booksaleproject.exception.LocalException.AuthorException.AuthorNotFoundException;
import com.musahalilecer.booksaleproject.mapper.AuthorMapper;
import com.musahalilecer.booksaleproject.model.Author;
import com.musahalilecer.booksaleproject.model.Book;
import com.musahalilecer.booksaleproject.repository.AuthorRepository;
import com.musahalilecer.booksaleproject.repository.BookRepository;
import com.musahalilecer.booksaleproject.service.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImp implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<AuthorResponse> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(AuthorMapper::toAuthorResponse).collect(Collectors.toList());
    }

    @Override
    public AuthorResponse getAuthorById(int id) {
        return authorRepository.findById(id)
                .map(AuthorMapper::toAuthorResponse)
                .orElseThrow(() -> new AuthorNotFoundException("Author not Found"));
    }

    @Override
    public AuthorResponse createAuthor(AuthorRequest authorRequest) {

        Author newAuthor = AuthorMapper.toAuthorEntity(authorRequest.getName(), authorRequest.getImage());
        Author savedAuthor = authorRepository.save(newAuthor);
        return AuthorMapper.toAuthorResponse(savedAuthor);


        /*
        Author author = new Author();
        author.setName(authorRequest.getName());
        author.setImage(authorRequest.getImage());

        if (authorRequest.getBookIds() != null && !authorRequest.getBookIds().isEmpty()) {
            List<Book> books = bookRepository.findAllById(authorRequest.getBookIds());
            author.setBooks(books);
        }

        Author saved = authorRepository.save(author);
        return AuthorMapper.toAuthorResponse(saved);

         */
    }

    @Override
    public AuthorResponse updateAuthor(int id, AuthorRequest authorRequest) {
        Author existingAuthor = authorRepository.findById(id).orElseThrow();
        AuthorMapper.toAuthorRequest(authorRequest, existingAuthor);
        Author newAuthor = authorRepository.save(existingAuthor);
        return AuthorMapper.toAuthorResponse(newAuthor);
    }

    @Override
    public void deleteAuthor(int id) {
    authorRepository.deleteById(id);
    }
}

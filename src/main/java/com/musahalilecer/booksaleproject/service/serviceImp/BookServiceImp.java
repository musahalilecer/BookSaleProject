package com.musahalilecer.booksaleproject.service.serviceImp;

import com.musahalilecer.booksaleproject.dto.request.AuthorRequest;
import com.musahalilecer.booksaleproject.dto.request.BookRequest;
import com.musahalilecer.booksaleproject.dto.response.BookResponse;
import com.musahalilecer.booksaleproject.exception.LocalException.AuthorException.AuthorNotFoundException;
import com.musahalilecer.booksaleproject.exception.LocalException.BookException.BookNotFoundException;
import com.musahalilecer.booksaleproject.exception.LocalException.BookException.LanguageNotFoundException;
import com.musahalilecer.booksaleproject.mapper.BookMapper;
import com.musahalilecer.booksaleproject.model.*;
import com.musahalilecer.booksaleproject.repository.*;
import com.musahalilecer.booksaleproject.service.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    PublisherRepository publisherRepository;

    private final BookMapper bookMapper;

    public BookServiceImp() {
        bookMapper = new BookMapper();
    }

    @Override
    public List<BookResponse> getAllBooks() {

        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookMapper::toBookResponse).collect(Collectors.toList());
    }

    @Override
    public BookResponse getBookById(int id) {
        return bookRepository.findWithAllRelationsById(id)
                .map(BookMapper::toBookResponse)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

/*
    @Override
    public BookResponse getBookById(int id) {
        return bookRepository.findById(id).map(BookMapper::toBookResponse).orElseThrow(
                () -> new BookNotFoundException("Book not found")
        );
    }

 */

    @Override
    public BookResponse createBook(BookRequest bookRequest) {

        /*
        Author newAuthor = AuthorMapper.toAuthorEntity(authorRequest.getName(), authorRequest.getImage());
        Author savedAuthor = authorRepository.save(newAuthor);
        return AuthorMapper.toAuthorResponse(savedAuthor);
         */

        Country country = countryRepository.findById(bookRequest.getCountryId())
                .orElseThrow(() -> new RuntimeException());

        Publisher publisher = publisherRepository.findById(bookRequest.getPublisherId())
                .orElseThrow();

        Author author = authorRepository.findById(bookRequest.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException("Author with ID " + bookRequest.getAuthorId() + " not found"));

        // Validate and find Language
        Language language = languageRepository.findById(bookRequest.getLanguageId())
                .orElseThrow(() -> new LanguageNotFoundException("Language with ID " + bookRequest.getLanguageId() + " not found"));

        // Convert DTO to Entity and save
        Book newBook = BookMapper.toBookEntity(
                bookRequest.getTitle(),
                author,
                bookRequest.getDescription(),
                language,
                bookRequest.getPage(),
                bookRequest.getImage(),
                bookRequest.getPrice(),
                publisher,
                country
        );

        Book savedBook = bookRepository.save(newBook);

        return BookMapper.toBookResponse(savedBook);

    }

    @Override
    public void deleteBook(int id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));
        book.setAuthor(null);
        book.setLanguage(null);

        bookRepository.delete(book);

        /*
        Book book = bookRepository.findById(id)
                .orElseThrow(null);

        // Clear relationships before deleting
        book.setAuthor(null);
        book.setLanguage(null);
        book.getGenres().clear();
        book.getCustomers().clear();
         */
    }


    @Override
    public BookResponse updateBook(int id, BookRequest bookRequest) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));

        Author author = authorRepository.findById(bookRequest.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException("Author with ID " + bookRequest.getAuthorId() + " not found"));

        Language language = languageRepository.findById(bookRequest.getLanguageId())
                .orElseThrow(() -> new LanguageNotFoundException("Language with ID " + bookRequest.getLanguageId() + " not found"));

        book.setTitle(bookRequest.getTitle());
        book.setDescription(bookRequest.getDescription());
        book.setImage(bookRequest.getImage());
        book.setPrice(bookRequest.getPrice());
        book.setAuthor(author);
        book.setLanguage(language);

        Book updated = bookRepository.save(book);
        return BookMapper.toBookResponse(updated);
    }
}

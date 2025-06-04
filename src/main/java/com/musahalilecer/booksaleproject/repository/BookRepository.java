package com.musahalilecer.booksaleproject.repository;

import com.musahalilecer.booksaleproject.model.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByAuthorId(Integer authorId);
    List<Book> findByLanguageId(Integer languageId);

    List<Book> findByAuthorName(String authorName);

    @EntityGraph(attributePaths = {"author", "publisher", "language", "country"})
    Optional<Book> findWithAllRelationsById(Integer id);
}

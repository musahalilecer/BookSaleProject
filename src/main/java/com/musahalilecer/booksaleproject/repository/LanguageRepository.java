package com.musahalilecer.booksaleproject.repository;

import com.musahalilecer.booksaleproject.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}

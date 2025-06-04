package com.musahalilecer.booksaleproject.repository;

import com.musahalilecer.booksaleproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

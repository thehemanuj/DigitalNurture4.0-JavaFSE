package com.library.library_management_spring_boot.repository;

import com.library.library_management_spring_boot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

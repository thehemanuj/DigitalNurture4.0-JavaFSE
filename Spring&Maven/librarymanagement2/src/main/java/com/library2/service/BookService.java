package com.library2.service;

import org.springframework.stereotype.Service;

import com.library2.repository.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;
    private String initMessage;

    // Constructor Injection
    public BookService(String initMessage) {
        this.initMessage = initMessage;
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("Init message: " + initMessage);
        bookRepository.findAll().forEach(System.out::println);
    }
}

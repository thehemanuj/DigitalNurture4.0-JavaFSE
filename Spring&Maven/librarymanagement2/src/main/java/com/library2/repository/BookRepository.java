package com.library2.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public List<String> findAll() {
        return Arrays.asList("1984", "Brave New World", "Fahrenheit 451");
    }
}

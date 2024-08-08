package com.Library.Library.Book;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunnerBook(
            BookRepository bookRepository
    ){
        return args -> {
            Book BookOne = new Book(
                    "978-3-16-148410-0",
                    "Book One",
                    "Author One",
                    2020,
                    "Publisher One",
                    300
            );
            Book Book2 = new Book(
                    "978-3-16-1456877-0",
                    "Book 2",
                    "Author 2",
                    1987,
                    "Publisher 2",
                    30
            );
            bookRepository.saveAll(
                    List.of(BookOne,Book2)
            );
        };
    }
}







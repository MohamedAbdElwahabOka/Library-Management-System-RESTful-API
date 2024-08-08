package com.Library.Library.Book;

import com.Library.Library.BorrowingRecord.BorrowingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BorrowingRecordRepository borrowingRecordRepository;
    @Autowired
    public BookService(BookRepository bookRepository, BorrowingRecordRepository borrowingRecordRepository) {
        this.bookRepository = bookRepository;
        this.borrowingRecordRepository = borrowingRecordRepository;
    }

//    public List<Book> getBooks() {
//        return bookRepository.findAll();
//    }
public List<Book> getBooks() {
    List<Book> books = bookRepository.findAll();
    books.forEach(this::updateBookStatus);
    return books;
}

    private void updateBookStatus(Book book) {
        boolean isAvailable = borrowingRecordRepository.findByBookAndReturnDateIsNull(book).isEmpty();
        book.setStatus(isAvailable ? "Available" : "Not Available");
    }

    public Book getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent()) {
            throw new IllegalStateException("Book with id " + id + " not found");
        }
        return book.get();
    }

    public  Book addNewBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Book with id " + id + " not found"));

        if (bookDetails.getTitle() != null) {
            book.setTitle(bookDetails.getTitle());
        }
        if (bookDetails.getAuthor() != null) {
            book.setAuthor(bookDetails.getAuthor());
        }
        if (bookDetails.getISBN() != null) {
            book.setISBN(bookDetails.getISBN());
        }
        if (bookDetails.getPublicationYear() != null) {
            book.setPublicationYear(bookDetails.getPublicationYear());
        }

        return bookRepository.save(book);
    }



    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalStateException("Book with id " + id + " not found");
        }
        bookRepository.deleteById(id);
    }

}




package com.Library.Library.BorrowingRecord;

import com.Library.Library.Book.BookRepository;
import com.Library.Library.Patron.Patron;
import com.Library.Library.Patron.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Library.Library.Book.Book;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowingRecordService {

    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;

    @Autowired
    public BorrowingRecordService(BorrowingRecordRepository borrowingRecordRepository, BookRepository bookRepository, PatronRepository patronRepository) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }

    public List<BorrowingRecord> getBorrowingRecords() {
        return borrowingRecordRepository.findAll();
    }

    public void borrowBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));
        Patron patron = patronRepository.findById(patronId).orElseThrow(() -> new IllegalArgumentException("Invalid patron ID"));
        boolean isAvailable = borrowingRecordRepository.findByBookAndReturnDateIsNull(book).isEmpty();
        // Check the book's status
        if (!isAvailable) {
            throw new IllegalStateException("The book is not available for borrowing right now.");
        }
        BorrowingRecord borrowingRecord = new BorrowingRecord(null,LocalDate.now(), patron,book);
        borrowingRecordRepository.save(borrowingRecord);
        updateBookStatus(book,patronId);

    }

    public void returnBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));
        BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookAndReturnDateIsNull(book).orElseThrow(() -> new IllegalArgumentException("No active borrowing record found"));
        borrowingRecord.setReturnDate(LocalDate.now());
        borrowingRecordRepository.save(borrowingRecord);
        updateBookStatus(book,patronId);
    }
    private void updateBookStatus(Book book ,Long patronId) {
        boolean isAvailable = borrowingRecordRepository.findByBookAndReturnDateIsNull(book).isEmpty();
        book.setStatus(isAvailable ? "Available" : "Not Available");
        bookRepository.save(book);
    }

}

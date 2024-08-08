package com.Library.Library.BorrowingRecord;

import com.Library.Library.Book.Book;
import com.Library.Library.Patron.Patron;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class BorrowingRecord {
    @Id
    @SequenceGenerator(
            name = "BorrowingRecord_sequence",
            sequenceName = "BorrowingRecord_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BorrowingRecord_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "patron_id", nullable = false)
    private Patron patron;

    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowingRecord() {}

    public BorrowingRecord(Long id, Book book, Patron patron, LocalDate borrowDate, LocalDate returnDate) {
        this.id = id;
        this.book = book;
        this.patron = patron;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public BorrowingRecord(LocalDate returnDate, LocalDate borrowDate, Patron patron, Book book) {
        this.returnDate = returnDate;
        this.borrowDate = borrowDate;
        this.patron = patron;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BorrowingRecord{" +
                "id=" + id +
                ", book=" + book +
                ", patron=" + patron +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}

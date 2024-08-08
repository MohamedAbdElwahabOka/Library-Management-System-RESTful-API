package com.Library.Library.Book;

import com.Library.Library.BorrowingRecord.BorrowingRecord;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "Book_sequence",
            sequenceName = "Book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Book_sequence"
    )
    private Long id;
    private String ISBN;
    private String title;
    private String author;
    private Integer publicationYear;
    private String publisher;
    private int pages;
    @Transient
    private String status;

    @OneToMany(mappedBy = "book")
    private List<BorrowingRecord> borrowingRecords;

    public Book() {
    }

    public Book(Long id, String ISBN, String title, String author, Integer publicationYear, String publisher, int pages) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.pages = pages;
    }

    public Book(String ISBN, String title, String author, Integer publicationYear, String publisher, int pages) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.pages = pages;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", publisher='" + publisher + '\'' +
                ", pages=" + pages +
                ", status='" + status + '\'' +
                '}';
    }
}

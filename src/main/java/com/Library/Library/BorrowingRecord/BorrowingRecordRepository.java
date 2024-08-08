package com.Library.Library.BorrowingRecord;

import com.Library.Library.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
    Optional<BorrowingRecord> findByBookIdAndPatronId(Long bookId, Long patronId);
    Optional<BorrowingRecord> findByBookAndReturnDateIsNull(Book book);

}

package com.Library.Library.BorrowingRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class BorrowingRecordController {

    private final BorrowingRecordService borrowingRecordService;

    @Autowired
    public BorrowingRecordController(BorrowingRecordService borrowingRecordService) {
        this.borrowingRecordService = borrowingRecordService;
    }

    @GetMapping
    public List<BorrowingRecord> getBorrowingRecords() {
        return borrowingRecordService.getBorrowingRecords();
    }


@PostMapping("/borrow/{bookId}/patron/{patronId}")
public ResponseEntity<String> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
    borrowingRecordService.borrowBook(bookId, patronId);
    return new ResponseEntity<>("Book with id " + bookId + " was borrowed successfully by patron with id " +patronId , HttpStatus.OK);
}


@PutMapping("/return/{bookId}/patron/{patronId}")
public ResponseEntity<String> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
    borrowingRecordService.returnBook(bookId, patronId);
    return new ResponseEntity<>("The patron with " +patronId+" return The Book with id " + bookId , HttpStatus.OK);
}
}

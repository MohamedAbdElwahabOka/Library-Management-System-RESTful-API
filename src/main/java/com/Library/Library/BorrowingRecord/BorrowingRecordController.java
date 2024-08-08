package com.Library.Library.BorrowingRecord;

import org.springframework.beans.factory.annotation.Autowired;
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

//    @PostMapping("/borrow/{bookId}/patron/{patronId}")
//    public BorrowingRecord borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
//        return borrowingRecordService.borrowBook(bookId, patronId);
//    }
@PostMapping("/borrow/{bookId}/patron/{patronId}")
public void borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
    borrowingRecordService.borrowBook(bookId, patronId);
}

//    @PutMapping("/return/{bookId}/patron/{patronId}")
//    public BorrowingRecord returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
//        return borrowingRecordService.returnBook(bookId, patronId);
//    }
@PutMapping("/return/{bookId}/patron/{patronId}")
public void returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
    borrowingRecordService.returnBook(bookId, patronId);
}
}

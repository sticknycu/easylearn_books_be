package ro.nicolaemariusghergu.easylearn.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.nicolaemariusghergu.easylearn.books.dto.BookDTO;
import ro.nicolaemariusghergu.easylearn.books.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/v1")
    public ResponseEntity<List<BookDTO>> getBooks() {
        return bookService.getBooks();
    }
}

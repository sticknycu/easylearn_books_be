package ro.nicolaemariusghergu.easylearn.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/v1")
    @ResponseBody
    public ResponseEntity<?> addBook(@RequestBody BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }

    @PatchMapping("/v1/{bookId}")
    @ResponseBody
    public ResponseEntity<?> modifyBook(@PathVariable Long bookId, @RequestBody BookDTO bookDTO) {
        return bookService.modifyBook(bookId, bookDTO);
    }

    @DeleteMapping("/v1/{bookId}")
    @ResponseBody
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
        return bookService.deleteBook(bookId);
    }
}

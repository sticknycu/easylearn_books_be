package ro.nicolaemariusghergu.easylearn.books.service;

import org.springframework.http.ResponseEntity;
import ro.nicolaemariusghergu.easylearn.books.dto.BookDTO;

import java.util.List;

public interface BookService {

    ResponseEntity<List<BookDTO>> getBooks();

    void saveBooks(List<BookDTO> books);

    List<BookDTO> getBooksFromRemote();
}

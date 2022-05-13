package ro.nicolaemariusghergu.easylearn.books.service;

import org.springframework.http.ResponseEntity;
import ro.nicolaemariusghergu.easylearn.books.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {

    ResponseEntity<List<AuthorDTO>> getAuthors();
}

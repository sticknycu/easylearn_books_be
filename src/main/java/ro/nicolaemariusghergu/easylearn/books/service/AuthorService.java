package ro.nicolaemariusghergu.easylearn.books.service;

import org.springframework.http.ResponseEntity;
import ro.nicolaemariusghergu.easylearn.books.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {

    ResponseEntity<List<AuthorDTO>> getAuthors();

    void saveAuthors(List<AuthorDTO> authors);

    List<AuthorDTO> getAuthorsFromRemote();
}

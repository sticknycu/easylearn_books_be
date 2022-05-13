package ro.nicolaemariusghergu.easylearn.books.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.nicolaemariusghergu.easylearn.books.dto.AuthorDTO;
import ro.nicolaemariusghergu.easylearn.books.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/api/authors/")
public record AuthorController(AuthorService authorService) {

    @GetMapping("/v1")
    public ResponseEntity<List<AuthorDTO>> getAuthors() {
        return authorService.getAuthors();
    }
}

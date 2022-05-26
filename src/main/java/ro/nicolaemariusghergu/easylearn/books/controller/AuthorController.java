package ro.nicolaemariusghergu.easylearn.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.nicolaemariusghergu.easylearn.books.dto.AuthorDTO;
import ro.nicolaemariusghergu.easylearn.books.service.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authors/")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/v1")
    public ResponseEntity<List<AuthorDTO>> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping("/v1")
    @ResponseBody
    public ResponseEntity<?> addAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.addAuthor(authorDTO);
    }

    @PatchMapping("/v1/{authorId}")
    @ResponseBody
    public ResponseEntity<?> modifyAuthor(@PathVariable Long authorId, @RequestBody AuthorDTO authorDTO) {
        return authorService.modifyAuthor(authorId, authorDTO);
    }

    @DeleteMapping("/v1/{authorId}")
    @ResponseBody
    public ResponseEntity<?> deleteAuthor(@PathVariable Long authorId) {
        return authorService.deleteAuthor(authorId);
    }
}

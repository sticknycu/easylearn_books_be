package ro.nicolaemariusghergu.easylearn.books.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.nicolaemariusghergu.easylearn.books.dto.AuthorDTO;
import ro.nicolaemariusghergu.easylearn.books.mapper.AuthorMapper;
import ro.nicolaemariusghergu.easylearn.books.repository.AuthorRepository;
import ro.nicolaemariusghergu.easylearn.books.service.AuthorService;

import java.util.List;

@Service
public record AuthorServiceImpl(AuthorRepository authorRepository)
        implements AuthorService {

    @Override
    public ResponseEntity<List<AuthorDTO>> getAuthors() {
        return ResponseEntity.ok(authorRepository.findAll().stream()
                .map(AuthorMapper.INSTANCE::authorToAuthorDto)
                .toList());
    }
}

package ro.nicolaemariusghergu.easylearn.books.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import ro.nicolaemariusghergu.easylearn.books.dto.AuthorDTO;
import ro.nicolaemariusghergu.easylearn.books.mapper.AuthorMapper;
import ro.nicolaemariusghergu.easylearn.books.repository.AuthorRepository;
import ro.nicolaemariusghergu.easylearn.books.service.AuthorService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final WebClient webClient;

    @Override
    public ResponseEntity<List<AuthorDTO>> getAuthors() {
        return ResponseEntity.ok(authorRepository.findAll().stream()
                .map(AuthorMapper.INSTANCE::authorToAuthorDto)
                .toList()
                .stream().distinct().toList());
    }

    @Transactional
    @Override
    public void saveAuthors(List<AuthorDTO> authors) {
        authorRepository.saveAllAndFlush(authors.stream()
                .map(AuthorMapper.INSTANCE::authorDtoToAuthor)
                .collect(Collectors.toSet()));
    }

    @Override
    public List<AuthorDTO> getAuthorsFromRemote() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/authors/v1")
                        .build())
                .retrieve()
                .bodyToFlux(AuthorDTO.class)
                .collectList()
                .block();
    }
}

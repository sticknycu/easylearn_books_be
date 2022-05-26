package ro.nicolaemariusghergu.easylearn.books.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import ro.nicolaemariusghergu.easylearn.books.dto.BookDTO;
import ro.nicolaemariusghergu.easylearn.books.mapper.BookMapper;
import ro.nicolaemariusghergu.easylearn.books.repository.BookRepository;
import ro.nicolaemariusghergu.easylearn.books.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final WebClient webClient;

    @Transactional
    @Override
    public void saveBooks(List<BookDTO> books) {
        bookRepository.saveAllAndFlush(books.stream()
                .map(BookMapper.INSTANCE::bookDtoToBook)
                .collect(Collectors.toSet()));
    }

    @Override
    public List<BookDTO> getBooksFromRemote() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/books/v1")
                        .build())
                .retrieve()
                .bodyToFlux(BookDTO.class)
                .collectList()
                .block();
    }
}

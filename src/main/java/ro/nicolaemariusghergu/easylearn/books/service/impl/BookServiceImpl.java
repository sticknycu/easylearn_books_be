package ro.nicolaemariusghergu.easylearn.books.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Override
    public ResponseEntity<List<BookDTO>> getBooks() {
        return ResponseEntity.ok(bookRepository.findAll().stream()
                .map(BookMapper.INSTANCE::bookToBookDto)
                .toList()
                .stream().distinct().toList());
    }

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

    @Override
    public ResponseEntity<?> addBook(BookDTO bookDTO) {
        if (bookRepository.findAll().stream()
                .filter(book -> book.getTitle().equals(bookDTO.getTitle()))
                .toList()
                .isEmpty()) {
            bookRepository.save(BookMapper.INSTANCE.bookDtoToBook(bookDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> modifyBook(Long id, BookDTO bookDTO) {
        if (bookRepository.findAll().stream()
                .filter(book -> book.getTitle().equals(bookDTO.getTitle()))
                .toList()
                .isEmpty()) {
            bookRepository.deleteById(id);
            bookRepository.save(BookMapper.INSTANCE.bookDtoToBook(bookDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteBook(Long id) {
        if (!bookRepository.findAll().stream()
                .filter(book -> book.getId().equals(id))
                .toList()
                .isEmpty()) {
            bookRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

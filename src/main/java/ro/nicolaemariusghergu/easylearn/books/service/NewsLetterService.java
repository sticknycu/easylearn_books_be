package ro.nicolaemariusghergu.easylearn.books.service;

import org.springframework.http.ResponseEntity;
import ro.nicolaemariusghergu.easylearn.books.dto.NewsLetterDTO;

public interface NewsLetterService {

    ResponseEntity<?> addNewsLetter(NewsLetterDTO newsLetterDTO);

    ResponseEntity<?> modifyNewsLetter(Long id, NewsLetterDTO newsLetterDTO);

    ResponseEntity<?> deleteNewsLetter(Long id);
}

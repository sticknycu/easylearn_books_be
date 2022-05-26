package ro.nicolaemariusghergu.easylearn.books.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.nicolaemariusghergu.easylearn.books.dto.NewsLetterDTO;
import ro.nicolaemariusghergu.easylearn.books.mapper.NewsLetterMapper;
import ro.nicolaemariusghergu.easylearn.books.repository.NewsLetterRepository;
import ro.nicolaemariusghergu.easylearn.books.service.NewsLetterService;

@RequiredArgsConstructor
@Service
public class NewsLetterServiceImpl implements NewsLetterService {

    private final NewsLetterRepository newsLetterRepository;

    @Override
    public ResponseEntity<?> addNewsLetter(NewsLetterDTO newsLetterDTO) {
        if (newsLetterRepository.findAll().stream()
                .filter(newsLetter -> newsLetter.getId().equals(newsLetterDTO.getId()))
                .toList()
                .isEmpty()) {
            newsLetterRepository.save(NewsLetterMapper.INSTANCE.newsLetterDtoNewsLetter(newsLetterDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> modifyNewsLetter(Long id, NewsLetterDTO newsLetterDTO) {
        if (newsLetterRepository.findAll().stream()
                .filter(newsLetter -> newsLetter.getId().equals(newsLetterDTO.getId()))
                .toList()
                .isEmpty()) {
            newsLetterRepository.deleteById(id);
            newsLetterRepository.save(NewsLetterMapper.INSTANCE.newsLetterDtoNewsLetter(newsLetterDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteNewsLetter(Long id) {
        if (!newsLetterRepository.findAll().stream()
                .filter(status -> status.getId().equals(id))
                .toList()
                .isEmpty()) {
            newsLetterRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

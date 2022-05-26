package ro.nicolaemariusghergu.easylearn.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.nicolaemariusghergu.easylearn.books.dto.NewsLetterDTO;
import ro.nicolaemariusghergu.easylearn.books.service.NewsLetterService;

@RestController
@RequestMapping("/api/news-letter")
@RequiredArgsConstructor
public class NewsLetterController {

    private final NewsLetterService newsLetterService;

    @PostMapping("/v1")
    @ResponseBody
    public ResponseEntity<?> addNewsLetter(@RequestBody NewsLetterDTO newsLetterDTO) {
        return newsLetterService.addNewsLetter(newsLetterDTO);
    }

    @PatchMapping("/v1/{newsLetterId}")
    @ResponseBody
    public ResponseEntity<?> modifyNewsLetter(@PathVariable Long newsLetterId, @RequestBody NewsLetterDTO newsLetterDTO) {
        return newsLetterService.modifyNewsLetter(newsLetterId, newsLetterDTO);
    }

    @DeleteMapping("/v1/{newsLetterId}")
    @ResponseBody
    public ResponseEntity<?> deleteNewsLetter(@PathVariable Long newsLetterId) {
        return newsLetterService.deleteNewsLetter(newsLetterId);
    }
}

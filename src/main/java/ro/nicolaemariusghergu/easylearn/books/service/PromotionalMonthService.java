package ro.nicolaemariusghergu.easylearn.books.service;

import org.springframework.http.ResponseEntity;
import ro.nicolaemariusghergu.easylearn.books.dto.PromotionalMonthDTO;

public interface PromotionalMonthService {

    ResponseEntity<?> addPromotionalMonth(PromotionalMonthDTO promotionalMonthDTO);

    ResponseEntity<?> modifyPromotionalMonth(Long id, PromotionalMonthDTO promotionalMonthDTO);

    ResponseEntity<?> deletePromotionalMonth(Long id);
}

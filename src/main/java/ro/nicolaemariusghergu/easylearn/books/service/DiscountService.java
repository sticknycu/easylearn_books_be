package ro.nicolaemariusghergu.easylearn.books.service;

import org.springframework.http.ResponseEntity;
import ro.nicolaemariusghergu.easylearn.books.dto.DiscountDTO;

public interface DiscountService {

    ResponseEntity<?> addDiscount(DiscountDTO discountDTO);

    ResponseEntity<?> modifyDiscount(Long id, DiscountDTO discountDTO);

    ResponseEntity<?> deleteDiscount(Long id);
}

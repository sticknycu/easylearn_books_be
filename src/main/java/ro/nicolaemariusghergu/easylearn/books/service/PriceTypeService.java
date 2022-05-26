package ro.nicolaemariusghergu.easylearn.books.service;

import org.springframework.http.ResponseEntity;
import ro.nicolaemariusghergu.easylearn.books.dto.PriceTypeDTO;

import java.util.List;

public interface PriceTypeService {

    ResponseEntity<List<PriceTypeDTO>> getPriceTypes();

    ResponseEntity<?> addPriceType(PriceTypeDTO priceTypeDTO);

    ResponseEntity<?> modifyPriceType(Long id, PriceTypeDTO priceTypeDTO);

    ResponseEntity<?> deletePriceType(Long id);
}

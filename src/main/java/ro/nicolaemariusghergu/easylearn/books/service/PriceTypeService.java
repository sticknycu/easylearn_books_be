package ro.nicolaemariusghergu.easylearn.books.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.nicolaemariusghergu.easylearn.books.dto.PriceTypeDTO;

import java.util.List;

public interface PriceTypeService {

    ResponseEntity<List<PriceTypeDTO>> getPriceTypes();
}

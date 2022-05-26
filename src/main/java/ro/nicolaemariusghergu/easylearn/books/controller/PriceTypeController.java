package ro.nicolaemariusghergu.easylearn.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.nicolaemariusghergu.easylearn.books.dto.PriceTypeDTO;
import ro.nicolaemariusghergu.easylearn.books.service.PriceTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/price-types")
public class PriceTypeController {

    private final PriceTypeService priceTypeService;

    @GetMapping("/v1")
    public ResponseEntity<List<PriceTypeDTO>> getPriceTypes() {
        return priceTypeService.getPriceTypes();
    }
}

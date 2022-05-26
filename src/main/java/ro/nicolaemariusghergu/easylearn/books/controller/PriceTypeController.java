package ro.nicolaemariusghergu.easylearn.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/v1")
    @ResponseBody
    public ResponseEntity<?> addPriceType(@RequestBody PriceTypeDTO priceTypeDTO) {
        return priceTypeService.addPriceType(priceTypeDTO);
    }

    @PatchMapping("/v1/{priceTypeId}")
    @ResponseBody
    public ResponseEntity<?> modifyPriceType(@PathVariable Long priceTypeId, @RequestBody PriceTypeDTO priceTypeDTO) {
        return priceTypeService.modifyPriceType(priceTypeId, priceTypeDTO);
    }

    @DeleteMapping("/v1/{priceTypeId}")
    @ResponseBody
    public ResponseEntity<?> deletePriceType(@PathVariable Long priceTypeId) {
        return priceTypeService.deletePriceType(priceTypeId);
    }
}

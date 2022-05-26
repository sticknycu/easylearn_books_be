package ro.nicolaemariusghergu.easylearn.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.nicolaemariusghergu.easylearn.books.dto.DiscountDTO;
import ro.nicolaemariusghergu.easylearn.books.service.DiscountService;

@RequestMapping("/api/discounts")
@RequiredArgsConstructor
@RestController
public class DiscountController {

    private final DiscountService discountService;

    @PostMapping("/v1")
    @ResponseBody
    public ResponseEntity<?> addDiscount(@RequestBody DiscountDTO discountDTO) {
        return discountService.addDiscount(discountDTO);
    }

    @PatchMapping("/v1/{discountId}")
    @ResponseBody
    public ResponseEntity<?> modifyDiscount(@PathVariable Long discountId, @RequestBody DiscountDTO discountDTO) {
        return discountService.modifyDiscount(discountId, discountDTO);
    }

    @DeleteMapping("/v1/{discountId}")
    @ResponseBody
    public ResponseEntity<?> deleteDiscount(@PathVariable Long discountId) {
        return discountService.deleteDiscount(discountId);
    }
}

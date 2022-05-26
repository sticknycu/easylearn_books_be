package ro.nicolaemariusghergu.easylearn.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.nicolaemariusghergu.easylearn.books.dto.PromotionalMonthDTO;
import ro.nicolaemariusghergu.easylearn.books.service.PromotionalMonthService;

@RestController
@RequestMapping("/api/promotional-month")
@RequiredArgsConstructor
public class PromotionalMonthController {

    private final PromotionalMonthService promotionalMonthService;

    @PostMapping("/v1")
    @ResponseBody
    public ResponseEntity<?> addPromotionalMonth(@RequestBody PromotionalMonthDTO promotionalMonthDTO) {
        return promotionalMonthService.addPromotionalMonth(promotionalMonthDTO);
    }

    @PatchMapping("/v1/{promotionalMonthId}")
    @ResponseBody
    public ResponseEntity<?> modifyPromotionalMonth(@PathVariable Long promotionalMonthId, @RequestBody PromotionalMonthDTO promotionalMonthDTO) {
        return promotionalMonthService.modifyPromotionalMonth(promotionalMonthId, promotionalMonthDTO);
    }

    @DeleteMapping("/v1/{promotionalMonthId}")
    @ResponseBody
    public ResponseEntity<?> deletePromotionalMonth(@PathVariable Long promotionalMonthId) {
        return promotionalMonthService.deletePromotionalMonth(promotionalMonthId);
    }
}

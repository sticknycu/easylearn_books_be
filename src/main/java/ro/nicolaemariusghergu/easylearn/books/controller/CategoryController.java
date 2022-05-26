package ro.nicolaemariusghergu.easylearn.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.nicolaemariusghergu.easylearn.books.dto.CategoryDTO;
import ro.nicolaemariusghergu.easylearn.books.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/v1")
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        return categoryService.getCategories();
    }
}

package ro.nicolaemariusghergu.easylearn.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/v1")
    @ResponseBody
    public ResponseEntity<?> addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.addCategory(categoryDTO);
    }

    @PatchMapping("/v1/{categoryId}")
    @ResponseBody
    public ResponseEntity<?> modifyCategory(@PathVariable Long categoryId, @RequestBody CategoryDTO categoryDTO) {
        return categoryService.modifyCategory(categoryId, categoryDTO);
    }

    @DeleteMapping("/v1/{categoryId}")
    @ResponseBody
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
}

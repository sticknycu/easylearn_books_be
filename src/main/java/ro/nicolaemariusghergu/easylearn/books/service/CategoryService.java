package ro.nicolaemariusghergu.easylearn.books.service;

import org.springframework.http.ResponseEntity;
import ro.nicolaemariusghergu.easylearn.books.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    ResponseEntity<List<CategoryDTO>> getCategories();

    void saveCategories(List<CategoryDTO> categories);

    List<CategoryDTO> getCategoriesFromRemote();

    ResponseEntity<?> addCategory(CategoryDTO categoryDTO);

    ResponseEntity<?> modifyCategory(Long id, CategoryDTO categoryDTO);

    ResponseEntity<?> deleteCategory(Long id);
}

package ro.nicolaemariusghergu.easylearn.books.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import ro.nicolaemariusghergu.easylearn.books.dto.CategoryDTO;
import ro.nicolaemariusghergu.easylearn.books.mapper.CategoryMapper;
import ro.nicolaemariusghergu.easylearn.books.repository.CategoryRepository;
import ro.nicolaemariusghergu.easylearn.books.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final WebClient webClient;

    @Override
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        return ResponseEntity.ok(categoryRepository.findAll().stream()
                .map(CategoryMapper.INSTANCE::categoryToCategoryDto)
                .toList()
                .stream().distinct().toList());
    }

    @Transactional
    @Override
    public void saveCategories(List<CategoryDTO> categories) {
        categoryRepository.saveAllAndFlush(categories.stream()
                .map(CategoryMapper.INSTANCE::categoryDtoToCategory)
                .collect(Collectors.toSet()));
    }

    @Override
    public List<CategoryDTO> getCategoriesFromRemote() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/categories/v1")
                        .build())
                .retrieve()
                .bodyToFlux(CategoryDTO.class)
                .collectList()
                .block();
    }

    @Override
    public ResponseEntity<?> addCategory(CategoryDTO categoryDTO) {
        if (categoryRepository.findAll().stream()
                .filter(category -> category.getName().equals(category.getName()))
                .toList()
                .isEmpty()) {
            categoryRepository.save(CategoryMapper.INSTANCE.categoryDtoToCategory(categoryDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> modifyCategory(Long id, CategoryDTO categoryDTO) {
        if (categoryRepository.findAll().stream()
                .filter(category -> category.getName().equals(categoryDTO.getName()))
                .toList()
                .isEmpty()) {
            categoryRepository.deleteById(id);
            categoryRepository.save(CategoryMapper.INSTANCE.categoryDtoToCategory(categoryDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteCategory(Long id) {
        if (!categoryRepository.findAll().stream()
                .filter(status -> status.getId().equals(id))
                .toList()
                .isEmpty()) {
            categoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

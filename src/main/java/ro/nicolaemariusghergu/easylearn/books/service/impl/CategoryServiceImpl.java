package ro.nicolaemariusghergu.easylearn.books.service.impl;

import lombok.RequiredArgsConstructor;
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
}

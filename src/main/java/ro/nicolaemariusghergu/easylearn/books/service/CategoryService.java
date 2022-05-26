package ro.nicolaemariusghergu.easylearn.books.service;

import ro.nicolaemariusghergu.easylearn.books.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    void saveCategories(List<CategoryDTO> categories);

    List<CategoryDTO> getCategoriesFromRemote();
}

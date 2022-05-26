package ro.nicolaemariusghergu.easylearn.books.mapper;

import javax.annotation.processing.Generated;
import ro.nicolaemariusghergu.easylearn.books.dto.CategoryDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.CategoryDTO.CategoryDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.entities.Category;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-26T17:14:01+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (GraalVM Community)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTOBuilder<?, ?> categoryDTO = CategoryDTO.builder();

        categoryDTO.id( category.getId() );
        categoryDTO.name( category.getName() );

        return categoryDTO.build();
    }

    @Override
    public Category categoryDtoToCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDTO.getId() );
        category.setName( categoryDTO.getName() );

        return category;
    }
}

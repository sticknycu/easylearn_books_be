package ro.nicolaemariusghergu.easylearn.books.mapper;

import javax.annotation.processing.Generated;
import ro.nicolaemariusghergu.easylearn.books.dto.AuthorDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.AuthorDTO.AuthorDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.entities.Author;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-26T17:14:01+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (GraalVM Community)"
)
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorDTO authorToAuthorDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDTOBuilder<?, ?> authorDTO = AuthorDTO.builder();

        authorDTO.id( author.getId() );
        authorDTO.name( author.getName() );

        return authorDTO.build();
    }

    @Override
    public Author authorDtoToAuthor(AuthorDTO authorDTO) {
        if ( authorDTO == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( authorDTO.getId() );
        author.setName( authorDTO.getName() );

        return author;
    }
}

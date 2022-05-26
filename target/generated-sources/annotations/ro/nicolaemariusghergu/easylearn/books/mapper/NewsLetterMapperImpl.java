package ro.nicolaemariusghergu.easylearn.books.mapper;

import javax.annotation.processing.Generated;
import ro.nicolaemariusghergu.easylearn.books.dto.NewsLetterDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.NewsLetterDTO.NewsLetterDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.entities.NewsLetter;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-26T17:14:01+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (GraalVM Community)"
)
public class NewsLetterMapperImpl implements NewsLetterMapper {

    @Override
    public NewsLetterDTO newsLetterToNewsLetterDto(NewsLetter newsLetter) {
        if ( newsLetter == null ) {
            return null;
        }

        NewsLetterDTOBuilder<?, ?> newsLetterDTO = NewsLetterDTO.builder();

        newsLetterDTO.id( newsLetter.getId() );

        return newsLetterDTO.build();
    }

    @Override
    public NewsLetter newsLetterDtoNewsLetter(NewsLetterDTO newsLetterDTO) {
        if ( newsLetterDTO == null ) {
            return null;
        }

        NewsLetter newsLetter = new NewsLetter();

        newsLetter.setId( newsLetterDTO.getId() );

        return newsLetter;
    }
}

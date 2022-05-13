package ro.nicolaemariusghergu.easylearn.books.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ro.nicolaemariusghergu.easylearn.books.dto.NewsLetterDTO;
import ro.nicolaemariusghergu.easylearn.books.model.entities.NewsLetter;

@Mapper
public interface NewsLetterMapper {

    NewsLetterMapper INSTANCE = Mappers.getMapper(NewsLetterMapper.class);

    NewsLetterDTO newsLetterToNewsLetterDto(NewsLetter newsLetter);

    NewsLetter newsLetterDtoNewsLetter(NewsLetterDTO newsLetterDTO);
}

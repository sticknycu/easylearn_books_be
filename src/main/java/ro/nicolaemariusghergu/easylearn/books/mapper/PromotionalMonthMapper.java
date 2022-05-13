package ro.nicolaemariusghergu.easylearn.books.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ro.nicolaemariusghergu.easylearn.books.dto.PromotionalMonthDTO;
import ro.nicolaemariusghergu.easylearn.books.model.entities.PromotionalMonth;

@Mapper
public interface PromotionalMonthMapper {

    PromotionalMonthMapper INSTANCE = Mappers.getMapper(PromotionalMonthMapper.class);

    PromotionalMonthDTO promotionalMonthToPromotionalMonthDto(PromotionalMonth promotionalMonth);

    PromotionalMonth promotionalMonthDtoToPromotionalMonth(PromotionalMonthDTO promotionalMonthDTO);
}

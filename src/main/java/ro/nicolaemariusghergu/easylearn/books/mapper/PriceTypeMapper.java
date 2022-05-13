package ro.nicolaemariusghergu.easylearn.books.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ro.nicolaemariusghergu.easylearn.books.dto.PriceTypeDTO;
import ro.nicolaemariusghergu.easylearn.books.model.entities.PriceType;

@Mapper
public interface PriceTypeMapper {

    PriceTypeMapper INSTANCE = Mappers.getMapper(PriceTypeMapper.class);

    PriceTypeDTO priceTypeToPriceTypeDto(PriceType priceType);

    PriceType priceTypeDtoToPriceType(PriceTypeDTO priceTypeDTO);
}

package ro.nicolaemariusghergu.easylearn.books.mapper;

import javax.annotation.processing.Generated;
import ro.nicolaemariusghergu.easylearn.books.dto.PriceTypeDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.PriceTypeDTO.PriceTypeDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.entities.PriceType;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-26T17:14:01+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (GraalVM Community)"
)
public class PriceTypeMapperImpl implements PriceTypeMapper {

    @Override
    public PriceTypeDTO priceTypeToPriceTypeDto(PriceType priceType) {
        if ( priceType == null ) {
            return null;
        }

        PriceTypeDTOBuilder<?, ?> priceTypeDTO = PriceTypeDTO.builder();

        priceTypeDTO.id( priceType.getId() );
        priceTypeDTO.value( priceType.getValue() );

        return priceTypeDTO.build();
    }

    @Override
    public PriceType priceTypeDtoToPriceType(PriceTypeDTO priceTypeDTO) {
        if ( priceTypeDTO == null ) {
            return null;
        }

        PriceType priceType = new PriceType();

        priceType.setId( priceTypeDTO.getId() );
        priceType.setValue( priceTypeDTO.getValue() );

        return priceType;
    }
}

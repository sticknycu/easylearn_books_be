package ro.nicolaemariusghergu.easylearn.books.mapper;

import javax.annotation.processing.Generated;
import ro.nicolaemariusghergu.easylearn.books.dto.DiscountDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.DiscountDTO.DiscountDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.entities.Discount;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-26T17:14:01+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (GraalVM Community)"
)
public class DiscountMapperImpl implements DiscountMapper {

    @Override
    public DiscountDTO discountToDiscountDto(Discount discount) {
        if ( discount == null ) {
            return null;
        }

        DiscountDTOBuilder<?, ?> discountDTO = DiscountDTO.builder();

        discountDTO.id( discount.getId() );
        discountDTO.value( discount.getValue() );

        return discountDTO.build();
    }

    @Override
    public Discount discountDtoToDiscount(DiscountDTO discountDTO) {
        if ( discountDTO == null ) {
            return null;
        }

        Discount discount = new Discount();

        discount.setId( discountDTO.getId() );
        discount.setValue( discountDTO.getValue() );

        return discount;
    }
}

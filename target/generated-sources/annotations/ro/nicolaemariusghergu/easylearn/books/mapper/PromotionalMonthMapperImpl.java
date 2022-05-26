package ro.nicolaemariusghergu.easylearn.books.mapper;

import javax.annotation.processing.Generated;
import ro.nicolaemariusghergu.easylearn.books.dto.DiscountDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.DiscountDTO.DiscountDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.dto.PromotionalMonthDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.PromotionalMonthDTO.PromotionalMonthDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.entities.Discount;
import ro.nicolaemariusghergu.easylearn.books.model.entities.PromotionalMonth;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-26T17:14:01+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (GraalVM Community)"
)
public class PromotionalMonthMapperImpl implements PromotionalMonthMapper {

    @Override
    public PromotionalMonthDTO promotionalMonthToPromotionalMonthDto(PromotionalMonth promotionalMonth) {
        if ( promotionalMonth == null ) {
            return null;
        }

        PromotionalMonthDTOBuilder<?, ?> promotionalMonthDTO = PromotionalMonthDTO.builder();

        promotionalMonthDTO.id( promotionalMonth.getId() );
        promotionalMonthDTO.discount( discountToDiscountDTO( promotionalMonth.getDiscount() ) );

        return promotionalMonthDTO.build();
    }

    @Override
    public PromotionalMonth promotionalMonthDtoToPromotionalMonth(PromotionalMonthDTO promotionalMonthDTO) {
        if ( promotionalMonthDTO == null ) {
            return null;
        }

        PromotionalMonth promotionalMonth = new PromotionalMonth();

        promotionalMonth.setId( promotionalMonthDTO.getId() );
        promotionalMonth.setDiscount( discountDTOToDiscount( promotionalMonthDTO.getDiscount() ) );

        return promotionalMonth;
    }

    protected DiscountDTO discountToDiscountDTO(Discount discount) {
        if ( discount == null ) {
            return null;
        }

        DiscountDTOBuilder<?, ?> discountDTO = DiscountDTO.builder();

        discountDTO.id( discount.getId() );
        discountDTO.value( discount.getValue() );

        return discountDTO.build();
    }

    protected Discount discountDTOToDiscount(DiscountDTO discountDTO) {
        if ( discountDTO == null ) {
            return null;
        }

        Discount discount = new Discount();

        discount.setId( discountDTO.getId() );
        discount.setValue( discountDTO.getValue() );

        return discount;
    }
}

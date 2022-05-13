package ro.nicolaemariusghergu.easylearn.books.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ro.nicolaemariusghergu.easylearn.books.dto.DiscountDTO;
import ro.nicolaemariusghergu.easylearn.books.model.entities.Discount;

@Mapper
public interface DiscountMapper {

    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

    DiscountDTO discountToDiscountDto(Discount discount);

    Discount discountDtoToDiscount(DiscountDTO discountDTO);
}

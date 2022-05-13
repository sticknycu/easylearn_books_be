package ro.nicolaemariusghergu.easylearn.books.dto;

import lombok.*;
import ro.nicolaemariusghergu.easylearn.books.model.dao.AbstractEntity;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class BookDTO extends AbstractEntity {

    private CategoryDTO category;

    private StatusDTO status;

    private DiscountDTO discount;

    private PriceTypeDTO priceType;

    private PublishHouseDTO publishHouse;

    private Integer stockCount;

    private String iconUrl;
}

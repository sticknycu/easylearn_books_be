package ro.nicolaemariusghergu.easylearn.books.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.dao.AbstractEntity;

import java.math.BigDecimal;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(
        exclude = {"category", "publishHouse", "discount", "status",
                "author", "priceType", "stockCount", "iconUrl"},
        callSuper = false
)
@ToString
public class BookDTO extends AbstractEntity {

    private String title;

    private CategoryDTO category;

    private StatusDTO status;

    private DiscountDTO discount;

    private PriceTypeDTO priceType;

    private PublishHouseDTO publishHouse;

    private Integer stockCount;

    private AuthorDTO author;

    private String iconUrl;

    private BigDecimal price;
}

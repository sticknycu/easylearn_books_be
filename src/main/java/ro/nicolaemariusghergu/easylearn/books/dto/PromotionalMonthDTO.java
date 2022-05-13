package ro.nicolaemariusghergu.easylearn.books.dto;

import lombok.*;
import ro.nicolaemariusghergu.easylearn.books.model.dao.AbstractEntity;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class PromotionalMonthDTO extends AbstractEntity {

    private DiscountDTO discount;
}

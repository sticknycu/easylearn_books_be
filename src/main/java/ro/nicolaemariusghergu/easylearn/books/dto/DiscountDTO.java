package ro.nicolaemariusghergu.easylearn.books.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.dao.AbstractEntity;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString
public class DiscountDTO extends AbstractEntity {

    private BigDecimal value;
}

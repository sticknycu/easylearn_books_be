package ro.nicolaemariusghergu.easylearn.books.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.dao.AbstractEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class PriceTypeDTO extends AbstractEntity {

    private String value;
}

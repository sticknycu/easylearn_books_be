package ro.nicolaemariusghergu.easylearn.books.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode
public abstract class AbstractEntityDTO {

    protected Long id;
}

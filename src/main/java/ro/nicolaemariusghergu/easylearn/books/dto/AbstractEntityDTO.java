package ro.nicolaemariusghergu.easylearn.books.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public abstract class AbstractEntityDTO {

    protected Long id;
}

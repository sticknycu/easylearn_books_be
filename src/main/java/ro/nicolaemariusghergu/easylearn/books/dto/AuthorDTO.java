package ro.nicolaemariusghergu.easylearn.books.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.dao.AbstractEntity;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class AuthorDTO extends AbstractEntity {

    private String name;
}

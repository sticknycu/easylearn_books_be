package ro.nicolaemariusghergu.easylearn.books.dto;

import lombok.*;
import ro.nicolaemariusghergu.easylearn.books.model.dao.AbstractEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder
public class CategoryDTO extends AbstractEntity {

    private String name;
}

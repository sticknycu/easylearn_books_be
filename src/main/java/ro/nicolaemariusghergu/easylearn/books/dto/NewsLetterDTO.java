package ro.nicolaemariusghergu.easylearn.books.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.dao.AbstractEntity;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class NewsLetterDTO extends AbstractEntity {

}

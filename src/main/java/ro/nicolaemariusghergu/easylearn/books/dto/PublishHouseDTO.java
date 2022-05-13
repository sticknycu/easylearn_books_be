package ro.nicolaemariusghergu.easylearn.books.dto;

import lombok.*;
import ro.nicolaemariusghergu.easylearn.books.model.dao.AbstractEntity;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class PublishHouseDTO extends AbstractEntity {

    private String name;
}

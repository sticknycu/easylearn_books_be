package ro.nicolaemariusghergu.easylearn.books.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StatusDTO extends AbstractEntityDTO {

    private String statusType;
}

package ro.nicolaemariusghergu.easylearn.books.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StatusDTO extends AbstractEntityDTO {

    private String statusType;
}

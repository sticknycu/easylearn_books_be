package ro.nicolaemariusghergu.easylearn.books.model.entities;

import lombok.*;
import org.hibernate.Hibernate;
import ro.nicolaemariusghergu.easylearn.books.model.dao.AbstractEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "price_types")
@AttributeOverride(name = "id", column = @Column(name = "price_type_id"))
public class PriceType extends AbstractEntity {

    @Column(name = "price_type_value")
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PriceType priceType = (PriceType) o;
        return id != null && Objects.equals(id, priceType.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

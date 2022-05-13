package ro.nicolaemariusghergu.easylearn.books.model;

import lombok.*;
import org.hibernate.Hibernate;
import ro.nicolaemariusghergu.easylearn.books.dao.AbstractEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "discounts")
@AttributeOverride(name = "id", column = @Column(name = "discount_id"))
public class Discount extends AbstractEntity {

    @Column(name = "discount_value")
    private BigDecimal value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Discount discount = (Discount) o;
        return id != null && Objects.equals(id, discount.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

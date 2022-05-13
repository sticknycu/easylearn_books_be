package ro.nicolaemariusghergu.easylearn.books.model.entities;

import lombok.*;
import org.hibernate.Hibernate;
import ro.nicolaemariusghergu.easylearn.books.model.dao.AbstractEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "promotional_month")
@AttributeOverride(name = "id", column = @Column(name = "book_id"))
public class PromotionalMonth extends AbstractEntity {

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PromotionalMonth that = (PromotionalMonth) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

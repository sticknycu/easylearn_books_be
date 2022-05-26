package ro.nicolaemariusghergu.easylearn.books.model.entities;

import lombok.*;
import org.hibernate.Hibernate;
import ro.nicolaemariusghergu.easylearn.books.model.dao.AbstractEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
@ToString
@AttributeOverride(name = "id", column = @Column(name = "book_id"))
public class Book extends AbstractEntity {

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_type_id")
    private PriceType priceType;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publish_house_id")
    private PublishHouse publishHouse;

    @Column(name = "stock_count")
    private Integer stockCount;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "title")
    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

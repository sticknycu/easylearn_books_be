package ro.nicolaemariusghergu.easylearn.books.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.nicolaemariusghergu.easylearn.books.model.entities.Discount;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, Long> {
}

package ro.nicolaemariusghergu.easylearn.books.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.nicolaemariusghergu.easylearn.books.model.entities.PriceType;

@Repository
public interface PriceTypeRepository extends CrudRepository<PriceType, Long> {
}

package ro.nicolaemariusghergu.easylearn.books.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ro.nicolaemariusghergu.easylearn.books.model.entities.PromotionalMonth;

@Repository
public interface PromotionalMonthRepository extends PagingAndSortingRepository<PromotionalMonth, Long> {
}

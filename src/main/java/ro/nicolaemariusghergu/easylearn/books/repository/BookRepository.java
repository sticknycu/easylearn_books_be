package ro.nicolaemariusghergu.easylearn.books.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ro.nicolaemariusghergu.easylearn.books.model.entities.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
}

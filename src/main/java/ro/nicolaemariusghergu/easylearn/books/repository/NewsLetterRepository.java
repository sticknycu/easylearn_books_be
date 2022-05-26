package ro.nicolaemariusghergu.easylearn.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.nicolaemariusghergu.easylearn.books.model.entities.NewsLetter;

@Repository
public interface NewsLetterRepository extends JpaRepository<NewsLetter, Long> {
}

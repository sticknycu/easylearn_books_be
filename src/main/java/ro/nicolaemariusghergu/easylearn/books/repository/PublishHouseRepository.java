package ro.nicolaemariusghergu.easylearn.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.nicolaemariusghergu.easylearn.books.model.entities.PublishHouse;

@Repository
public interface PublishHouseRepository extends JpaRepository<PublishHouse, Long> {
}

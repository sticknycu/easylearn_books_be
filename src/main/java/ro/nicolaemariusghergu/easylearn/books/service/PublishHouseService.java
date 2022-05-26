package ro.nicolaemariusghergu.easylearn.books.service;

import org.springframework.http.ResponseEntity;
import ro.nicolaemariusghergu.easylearn.books.dto.PublishHouseDTO;

import java.util.List;

public interface PublishHouseService {
    ResponseEntity<List<PublishHouseDTO>> getPublishHouses();

    List<PublishHouseDTO> getPublishHousesFromRemote();

    void savePublishHouses(List<PublishHouseDTO> publishHouses);
}

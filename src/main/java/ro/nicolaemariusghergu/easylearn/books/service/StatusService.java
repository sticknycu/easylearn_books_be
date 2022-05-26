package ro.nicolaemariusghergu.easylearn.books.service;

import org.springframework.http.ResponseEntity;
import ro.nicolaemariusghergu.easylearn.books.dto.StatusDTO;

import java.util.List;

public interface StatusService {

    ResponseEntity<List<StatusDTO>> getStatuses();

    List<StatusDTO> getStatusFromRemote();

    void saveStatuses(List<StatusDTO> statuses);

    ResponseEntity<?> addStatus(StatusDTO statusDTO);

    ResponseEntity<?> modifyStatus(Long id, StatusDTO statusDTO);

    ResponseEntity<?> deleteStatus(Long id);
}

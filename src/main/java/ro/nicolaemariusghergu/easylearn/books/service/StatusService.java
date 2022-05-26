package ro.nicolaemariusghergu.easylearn.books.service;

import ro.nicolaemariusghergu.easylearn.books.dto.StatusDTO;

import java.util.List;

public interface StatusService {

    List<StatusDTO> getStatusFromRemote();

    void saveStatuses(List<StatusDTO> statuses);
}

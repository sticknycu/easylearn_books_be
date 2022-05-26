package ro.nicolaemariusghergu.easylearn.books.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import ro.nicolaemariusghergu.easylearn.books.dto.StatusDTO;
import ro.nicolaemariusghergu.easylearn.books.mapper.StatusMapper;
import ro.nicolaemariusghergu.easylearn.books.repository.StatusRepository;
import ro.nicolaemariusghergu.easylearn.books.service.StatusService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;
    private final WebClient webClient;

    @Override
    public ResponseEntity<List<StatusDTO>> getStatuses() {
        return ResponseEntity.ok(statusRepository.findAll().stream()
                .map(StatusMapper.INSTANCE::statusToStatusDto)
                .toList()
                .stream().distinct().toList());
    }

    @Override
    public List<StatusDTO> getStatusFromRemote() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/status-types/v1")
                        .build())
                .retrieve()
                .bodyToFlux(StatusDTO.class)
                .collectList()
                .block();
    }

    @Transactional
    @Override
    public void saveStatuses(List<StatusDTO> statuses) {
        statusRepository.saveAllAndFlush(statuses.stream()
                .map(StatusMapper.INSTANCE::statusDtoToStatus)
                .collect(Collectors.toSet()));
    }

    @Override
    public ResponseEntity<?> addStatus(StatusDTO statusDTO) {
        if (statusRepository.findAll().stream()
                .filter(status -> status.getStatusType().equals(statusDTO.getStatusType()))
                .toList()
                .isEmpty()) {
            statusRepository.save(StatusMapper.INSTANCE.statusDtoToStatus(statusDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> modifyStatus(Long id, StatusDTO statusDTO) {
        if (statusRepository.findAll().stream()
                .filter(status -> status.getStatusType().equals(statusDTO.getStatusType()))
                .toList()
                .isEmpty()) {
            statusRepository.deleteById(id);
            statusRepository.save(StatusMapper.INSTANCE.statusDtoToStatus(statusDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteStatus(Long id) {
        if (!statusRepository.findAll().stream()
                .filter(status -> status.getId().equals(id))
                .toList()
                .isEmpty()) {
            statusRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

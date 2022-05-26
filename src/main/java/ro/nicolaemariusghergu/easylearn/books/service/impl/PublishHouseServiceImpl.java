package ro.nicolaemariusghergu.easylearn.books.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import ro.nicolaemariusghergu.easylearn.books.dto.PublishHouseDTO;
import ro.nicolaemariusghergu.easylearn.books.mapper.PublishHouseMapper;
import ro.nicolaemariusghergu.easylearn.books.repository.PublishHouseRepository;
import ro.nicolaemariusghergu.easylearn.books.service.PublishHouseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublishHouseServiceImpl implements PublishHouseService {

    private final PublishHouseRepository publishHouseRepository;
    private final WebClient webClient;

    @Override
    public ResponseEntity<List<PublishHouseDTO>> getPublishHouses() {
        return ResponseEntity.ok(publishHouseRepository.findAll().stream()
                .map(PublishHouseMapper.INSTANCE::publishHouseToPublishHouseDto)
                .toList().stream().distinct().toList());
    }

    @Transactional
    @Override
    public void savePublishHouses(List<PublishHouseDTO> publishHouses) {
        publishHouseRepository.saveAllAndFlush(publishHouses.stream()
                .map(PublishHouseMapper.INSTANCE::publishHouseDtoToPublishHouse)
                .collect(Collectors.toSet()));
    }

    @Override
    public ResponseEntity<?> addPublishHouse(PublishHouseDTO publishHouseDTO) {
        if (publishHouseRepository.findAll().stream()
                .filter(publishHouse -> publishHouse.getName().equals(publishHouseDTO.getName()))
                .toList()
                .isEmpty()) {
            publishHouseRepository.save(PublishHouseMapper.INSTANCE.publishHouseDtoToPublishHouse(publishHouseDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> modifyPublishHouse(Long id, PublishHouseDTO publishHouseDTO) {
        if (publishHouseRepository.findAll().stream()
                .filter(publishHouse -> publishHouse.getName().equals(publishHouseDTO.getName()))
                .toList()
                .isEmpty()) {
            publishHouseRepository.deleteById(id);
            publishHouseRepository.save(PublishHouseMapper.INSTANCE.publishHouseDtoToPublishHouse(publishHouseDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deletePublishHouse(Long id) {
        if (!publishHouseRepository.findAll().stream()
                .filter(publishHouse -> publishHouse.getId().equals(id))
                .toList()
                .isEmpty()) {
            publishHouseRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<PublishHouseDTO> getPublishHousesFromRemote() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/publish-houses/v1")
                        .build())
                .retrieve()
                .bodyToFlux(PublishHouseDTO.class)
                .collectList()
                .block();
    }
}

package ro.nicolaemariusghergu.easylearn.books.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.nicolaemariusghergu.easylearn.books.dto.PromotionalMonthDTO;
import ro.nicolaemariusghergu.easylearn.books.mapper.PromotionalMonthMapper;
import ro.nicolaemariusghergu.easylearn.books.repository.PromotionalMonthRepository;
import ro.nicolaemariusghergu.easylearn.books.service.PromotionalMonthService;

@RequiredArgsConstructor
@Service
public class PromotionalMonthServiceImpl implements PromotionalMonthService {

    private final PromotionalMonthRepository promotionalMonthRepository;

    @Override
    public ResponseEntity<?> addPromotionalMonth(PromotionalMonthDTO promotionalMonthDTO) {
        if (promotionalMonthRepository.findAll().stream()
                .filter(promotionalMonth -> promotionalMonth.getId().equals(promotionalMonthDTO.getId()))
                .toList()
                .isEmpty()) {
            promotionalMonthRepository.save(PromotionalMonthMapper.INSTANCE.promotionalMonthDtoToPromotionalMonth(promotionalMonthDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> modifyPromotionalMonth(Long id, PromotionalMonthDTO promotionalMonthDTO) {
        if (promotionalMonthRepository.findAll().stream()
                .filter(promotionalMonth -> promotionalMonth.getId().equals(promotionalMonthDTO.getId()))
                .toList()
                .isEmpty()) {
            promotionalMonthRepository.deleteById(id);
            promotionalMonthRepository.save(PromotionalMonthMapper.INSTANCE.promotionalMonthDtoToPromotionalMonth(promotionalMonthDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deletePromotionalMonth(Long id) {
        if (!promotionalMonthRepository.findAll().stream()
                .filter(promotionalMonth -> promotionalMonth.getId().equals(id))
                .toList()
                .isEmpty()) {
            promotionalMonthRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

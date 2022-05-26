package ro.nicolaemariusghergu.easylearn.books.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.nicolaemariusghergu.easylearn.books.dto.DiscountDTO;
import ro.nicolaemariusghergu.easylearn.books.mapper.DiscountMapper;
import ro.nicolaemariusghergu.easylearn.books.repository.DiscountRepository;
import ro.nicolaemariusghergu.easylearn.books.service.DiscountService;

@RequiredArgsConstructor
@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    @Override
    public ResponseEntity<?> addDiscount(DiscountDTO discountDTO) {
        if (discountRepository.findAll().stream()
                .filter(discount -> discount.getId().equals(discountDTO.getId()))
                .toList()
                .isEmpty()) {
            discountRepository.save(DiscountMapper.INSTANCE.discountDtoToDiscount(discountDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> modifyDiscount(Long id, DiscountDTO discountDTO) {
        if (discountRepository.findAll().stream()
                .filter(discount -> discount.getId().equals(discountDTO.getId()))
                .toList()
                .isEmpty()) {
            discountRepository.deleteById(id);
            discountRepository.save(DiscountMapper.INSTANCE.discountDtoToDiscount(discountDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteDiscount(Long id) {
        if (!discountRepository.findAll().stream()
                .filter(discount -> discount.getId().equals(id))
                .toList()
                .isEmpty()) {
            discountRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

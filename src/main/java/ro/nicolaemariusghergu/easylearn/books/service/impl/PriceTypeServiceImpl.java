package ro.nicolaemariusghergu.easylearn.books.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.nicolaemariusghergu.easylearn.books.dto.PriceTypeDTO;
import ro.nicolaemariusghergu.easylearn.books.mapper.PriceTypeMapper;
import ro.nicolaemariusghergu.easylearn.books.repository.PriceTypeRepository;
import ro.nicolaemariusghergu.easylearn.books.service.PriceTypeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceTypeServiceImpl implements PriceTypeService {

    private final PriceTypeRepository priceTypeRepository;

    @Override
    public ResponseEntity<List<PriceTypeDTO>> getPriceTypes() {
        return ResponseEntity.ok(priceTypeRepository.findAll().stream()
                .map(PriceTypeMapper.INSTANCE::priceTypeToPriceTypeDto)
                .toList().stream().distinct().toList());
    }

    @Override
    public ResponseEntity<?> addPriceType(PriceTypeDTO priceTypeDTO) {
        if (priceTypeRepository.findAll().stream()
                .filter(priceType -> priceType.getValue().equals(priceTypeDTO.getValue()))
                .toList()
                .isEmpty()) {
            priceTypeRepository.save(PriceTypeMapper.INSTANCE.priceTypeDtoToPriceType(priceTypeDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> modifyPriceType(Long id, PriceTypeDTO priceTypeDTO) {
        if (priceTypeRepository.findAll().stream()
                .filter(priceType -> priceType.getValue().equals(priceTypeDTO.getValue()))
                .toList()
                .isEmpty()) {
            priceTypeRepository.deleteById(id);
            priceTypeRepository.save(PriceTypeMapper.INSTANCE.priceTypeDtoToPriceType(priceTypeDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deletePriceType(Long id) {
        if (!priceTypeRepository.findAll().stream()
                .filter(priceType -> priceType.getId().equals(id))
                .toList()
                .isEmpty()) {
            priceTypeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

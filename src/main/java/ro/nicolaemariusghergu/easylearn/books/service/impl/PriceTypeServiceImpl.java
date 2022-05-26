package ro.nicolaemariusghergu.easylearn.books.service.impl;

import lombok.RequiredArgsConstructor;
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
}

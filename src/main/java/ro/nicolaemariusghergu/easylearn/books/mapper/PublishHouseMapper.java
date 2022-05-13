package ro.nicolaemariusghergu.easylearn.books.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ro.nicolaemariusghergu.easylearn.books.dto.PublishHouseDTO;
import ro.nicolaemariusghergu.easylearn.books.model.entities.PublishHouse;

@Mapper
public interface PublishHouseMapper {

    PublishHouseMapper INSTANCE = Mappers.getMapper(PublishHouseMapper.class);


    PublishHouseDTO publishHouseToPublishHouseDto(PublishHouse publishHouse);

    PublishHouse publishHouseDtoToPublishHouse(PublishHouseDTO publishHouseDTO);
}

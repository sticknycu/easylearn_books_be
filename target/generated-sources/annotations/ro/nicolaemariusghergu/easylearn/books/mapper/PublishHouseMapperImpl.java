package ro.nicolaemariusghergu.easylearn.books.mapper;

import javax.annotation.processing.Generated;
import ro.nicolaemariusghergu.easylearn.books.dto.PublishHouseDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.PublishHouseDTO.PublishHouseDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.entities.PublishHouse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-26T17:14:01+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (GraalVM Community)"
)
public class PublishHouseMapperImpl implements PublishHouseMapper {

    @Override
    public PublishHouseDTO publishHouseToPublishHouseDto(PublishHouse publishHouse) {
        if ( publishHouse == null ) {
            return null;
        }

        PublishHouseDTOBuilder<?, ?> publishHouseDTO = PublishHouseDTO.builder();

        publishHouseDTO.id( publishHouse.getId() );
        publishHouseDTO.name( publishHouse.getName() );

        return publishHouseDTO.build();
    }

    @Override
    public PublishHouse publishHouseDtoToPublishHouse(PublishHouseDTO publishHouseDTO) {
        if ( publishHouseDTO == null ) {
            return null;
        }

        PublishHouse publishHouse = new PublishHouse();

        publishHouse.setId( publishHouseDTO.getId() );
        publishHouse.setName( publishHouseDTO.getName() );

        return publishHouse;
    }
}

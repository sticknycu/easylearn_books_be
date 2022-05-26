package ro.nicolaemariusghergu.easylearn.books.mapper;

import javax.annotation.processing.Generated;
import ro.nicolaemariusghergu.easylearn.books.dto.StatusDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.StatusDTO.StatusDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.entities.Status;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-26T17:14:01+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (GraalVM Community)"
)
public class StatusMapperImpl implements StatusMapper {

    @Override
    public StatusDTO statusToStatusDto(Status status) {
        if ( status == null ) {
            return null;
        }

        StatusDTOBuilder<?, ?> statusDTO = StatusDTO.builder();

        statusDTO.id( status.getId() );
        statusDTO.statusType( status.getStatusType() );

        return statusDTO.build();
    }

    @Override
    public Status statusDtoToStatus(StatusDTO statusDTO) {
        if ( statusDTO == null ) {
            return null;
        }

        Status status = new Status();

        status.setId( statusDTO.getId() );
        status.setStatusType( statusDTO.getStatusType() );

        return status;
    }
}

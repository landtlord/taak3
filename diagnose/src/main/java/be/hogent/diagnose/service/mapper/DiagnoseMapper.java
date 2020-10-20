package be.hogent.diagnose.service.mapper;

import be.hogent.diagnose.business.DiagnoseEntity;
import be.hogent.diagnose.service.dto.Diagnose;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Mapper(componentModel = "spring")
public interface DiagnoseMapper {
    Diagnose toDTO(DiagnoseEntity diagnoseEntity);

    DiagnoseEntity toEntity(Diagnose diagnose);

    default List<Diagnose> toDTO(Iterable<DiagnoseEntity> diagnoseEntities){
        return StreamSupport.stream(diagnoseEntities.spliterator(), false)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}

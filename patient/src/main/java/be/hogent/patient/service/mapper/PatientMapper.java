package be.hogent.patient.service.mapper;

import be.hogent.patient.business.PatientEntity;
import be.hogent.patient.service.dto.Patient;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toDTO(PatientEntity patientEntity);

    PatientEntity toEntity(Patient patient);

    default List<Patient> toDTO(Iterable<PatientEntity> patientEntities){
        return StreamSupport.stream(patientEntities.spliterator(), false)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}

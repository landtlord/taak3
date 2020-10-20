package be.hogent.doctor.service.mapper;

import be.hogent.doctor.business.DoctorEntity;
import be.hogent.doctor.service.dto.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    @Mapping(target = "appointmentDate", dateFormat = "dd/MM/yyyy")
    Doctor toDTO(DoctorEntity doctorEntity);

    @Mapping(target = "appointmentDate", dateFormat = "dd/MM/yyyy")
    DoctorEntity toEntity(Doctor doctor);

    default List<Doctor> toDTO(Iterable<DoctorEntity> doctorEntities){
        return StreamSupport.stream(doctorEntities.spliterator(), false)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}

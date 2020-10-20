package be.hogent.doctor.business.repo;

import be.hogent.doctor.business.DoctorEntity;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepo extends CrudRepository<DoctorEntity, Long> {
}

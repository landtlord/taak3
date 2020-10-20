package be.hogent.patient.business.repo;

import be.hogent.patient.business.PatientEntity;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepo extends CrudRepository<PatientEntity, Long> {
}

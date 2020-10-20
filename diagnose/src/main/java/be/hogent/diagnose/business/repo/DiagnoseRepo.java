package be.hogent.diagnose.business.repo;

import be.hogent.diagnose.business.DiagnoseEntity;
import org.springframework.data.repository.CrudRepository;

public interface DiagnoseRepo extends CrudRepository<DiagnoseEntity, Long> {
}

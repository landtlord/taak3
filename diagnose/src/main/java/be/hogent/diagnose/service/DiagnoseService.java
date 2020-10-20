package be.hogent.diagnose.service;

import be.hogent.diagnose.business.repo.DiagnoseRepo;
import be.hogent.diagnose.service.dto.Diagnose;
import be.hogent.diagnose.service.mapper.DiagnoseMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiagnoseService {
    @Autowired
    private final DiagnoseRepo repo;

    @Autowired
    private final DiagnoseMapper mapper;

    public Diagnose getById(long id) {
        return repo.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    public List<Diagnose> getAll() {
        return mapper.toDTO(repo.findAll());
    }

    public Diagnose save(Diagnose diagnose) {
        return mapper.toDTO(
                repo.save(
                        mapper.toEntity(diagnose)));
    }

}

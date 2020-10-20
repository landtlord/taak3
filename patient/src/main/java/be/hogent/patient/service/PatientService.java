package be.hogent.patient.service;

import be.hogent.patient.business.repo.PatientRepo;
import be.hogent.patient.service.dto.Patient;
import be.hogent.patient.service.mapper.PatientMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {
    @Autowired
    private final PatientRepo repo;

    @Autowired
    private final PatientMapper mapper;

    public Patient getById(long id) {
        return repo.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    public List<Patient> getAll() {
        return mapper.toDTO(repo.findAll());
    }

    public Patient save(Patient patient) {
        return mapper.toDTO(
                repo.save(
                        mapper.toEntity(patient)));
    }

}

package be.hogent.doctor.service;

import be.hogent.doctor.business.repo.DoctorRepo;
import be.hogent.doctor.service.dto.Diagnose;
import be.hogent.doctor.service.dto.Doctor;
import be.hogent.doctor.service.dto.Patient;
import be.hogent.doctor.service.mapper.DoctorMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorService {
    @Autowired
    private final DoctorRepo repo;

    @Autowired
    private final DoctorMapper mapper;

    public Doctor getById(long id) {
        return repo.findById(id)
                .map(mapper::toDTO)
                .map(this::enrich)
                .orElse(null);
    }

    public List<Doctor> getAll() {
        return mapper.toDTO(
                repo.findAll())
                .stream()
                .map(this::enrich)
                .collect(Collectors.toList());
    }

    public Doctor save(Doctor doctor) {
        return enrich(
                mapper.toDTO(
                        repo.save(
                                mapper.toEntity(doctor))));
    }

    private Doctor enrich(Doctor doctor) {
        doctor.setDiagnose(new RestTemplate().getForObject("http://localhost:7070/api/diagnosises/" + doctor.getDiagnosisId(), Diagnose.class));
        doctor.setPatient(new RestTemplate().getForObject("http://localhost:8080/api/patients/" + doctor.getPatientId(), Patient.class));
        return doctor;
    }

}

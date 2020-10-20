package be.hogent.doctor.business;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class DoctorEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String patientId;
    private String diagnosisId;
    private LocalDate appointmentDate;
    private String consultation;
}

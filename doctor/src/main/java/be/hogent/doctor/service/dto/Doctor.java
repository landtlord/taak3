package be.hogent.doctor.service.dto;

import lombok.Data;

@Data
public class Doctor {
    private Long id;

    private String patientId;
    private String diagnosisId;
    private String appointmentDate;
    private String consultation;

    private Patient patient;

    private Diagnose diagnose;
}

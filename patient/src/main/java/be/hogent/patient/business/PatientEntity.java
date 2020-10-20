package be.hogent.patient.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PatientEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;
}

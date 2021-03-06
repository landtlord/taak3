package be.hogent.patient.business;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class PatientEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
}

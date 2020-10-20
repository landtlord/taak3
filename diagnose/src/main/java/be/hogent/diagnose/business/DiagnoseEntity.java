package be.hogent.diagnose.business;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class DiagnoseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
}

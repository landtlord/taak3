package be.hogent.doctor.service.dto;

import lombok.Data;

@Data
public class Diagnose {
    private Long id;

    private String name;
    private String description;
}

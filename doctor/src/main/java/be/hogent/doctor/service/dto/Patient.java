package be.hogent.doctor.service.dto;

import lombok.Data;

@Data
public class Patient {
    private Long id;

    private String name;
    private String email;
}

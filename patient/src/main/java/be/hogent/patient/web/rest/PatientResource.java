package be.hogent.patient.web.rest;

import be.hogent.patient.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PatientResource {
    @Autowired
    private PatientService service;
}

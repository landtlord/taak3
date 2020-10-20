package be.hogent.patient.web.rest;

import be.hogent.patient.service.PatientService;
import be.hogent.patient.service.dto.Patient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PatientResource {
    @Autowired
    private PatientService service;

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/patient/")
    public ResponseEntity<List<Patient>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/patient")
    public ResponseEntity<Patient> save(@RequestBody Patient patient) {
        return ResponseEntity.ok(service.save(patient));
    }
}

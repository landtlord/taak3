package be.hogent.doctor.rest;

import be.hogent.doctor.service.DoctorService;
import be.hogent.doctor.service.dto.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DoctorResource {
    @Autowired
    private final DoctorService service;

    @GetMapping("/docters/{id}")
    public ResponseEntity<Doctor> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/docters")
    public ResponseEntity<List<Doctor>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/docters")
    public ResponseEntity<Doctor> save(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(service.save(doctor));
    }
}

package be.hogent.diagnose.rest;

import be.hogent.diagnose.service.DiagnoseService;
import be.hogent.diagnose.service.dto.Diagnose;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DiagnoseResource {
    @Autowired
    private final DiagnoseService service;

    @GetMapping("/diagnosises/{id}")
    public ResponseEntity<Diagnose> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/diagnosises")
    public ResponseEntity<List<Diagnose>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/diagnosises")
    public ResponseEntity<Diagnose> save(@RequestBody Diagnose diagnose) {
        return ResponseEntity.ok(service.save(diagnose));
    }
}

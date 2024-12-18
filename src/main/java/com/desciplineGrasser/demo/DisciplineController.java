package com.desciplineGrasser.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;

    // Create or Update a Discipline
    @PostMapping
    public ResponseEntity<Discipline> createDiscipline(@RequestBody Discipline discipline) {
        return ResponseEntity.ok(disciplineService.saveDiscipline(discipline));
    }

    // Get All Disciplines
    @GetMapping
    public ResponseEntity<List<Discipline>> getAllDisciplines() {
        return ResponseEntity.ok(disciplineService.getAllDisciplines());
    }

    // Get Discipline by ID
    @GetMapping("/{id}")
    public ResponseEntity<Discipline> getDisciplineById(@PathVariable String id) {
        Optional<Discipline> user = disciplineService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Discipline
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscipline(@PathVariable String id) {
        disciplineService.deleteDiscipline(id);
        return ResponseEntity.noContent().build();
    }
}
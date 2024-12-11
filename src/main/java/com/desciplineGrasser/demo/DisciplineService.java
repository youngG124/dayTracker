package com.desciplineGrasser.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplineService {
    @Autowired
    private DisciplineRepository disciplineRepository;

    // Create or Update
    public Discipline saveDiscipline(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    // Read All
    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();
    }

    // Read by ID
    public Optional<Discipline> getUserById(String id) {
        return disciplineRepository.findById(id);
    }

    // Delete
    public void deleteDiscipline(String id) {
        disciplineRepository.deleteById(id);
    }
}
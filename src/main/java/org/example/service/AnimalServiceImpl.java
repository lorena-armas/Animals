package org.example.service;

import org.example.dto.AnimalDTO;
import org.example.repository.AnimalRepository;

import java.util.List;

public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository repository;

    public AnimalServiceImpl() {
        this.repository = new AnimalRepository();
    }

    @Override
    public List<AnimalDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public AnimalDTO findByCode(String code) {
        return repository.findByCode(code);
    }
}

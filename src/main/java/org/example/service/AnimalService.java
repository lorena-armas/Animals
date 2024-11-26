package org.example.service;

import org.example.dto.AnimalDTO;
import java.util.List;

public interface AnimalService {

    List<AnimalDTO> findAll();

    AnimalDTO findByCode(String code);
}

package org.example.dao;

import org.example.dto.AnimalDTO;
import java.util.List;

public interface AnimalDAO {

    List<AnimalDTO> findAll();

    AnimalDTO findByCode(String code);

}

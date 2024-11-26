package org.example.repository;

import org.example.dao.AnimalDAO;
import org.example.dao.AnimalDAOImpl;
import org.example.dto.AnimalDTO;
import java.util.List;

public class AnimalRepository {

    private final AnimalDAO animalDAO;

    public AnimalRepository() {
        this.animalDAO =  new AnimalDAOImpl();
    }

    public List<AnimalDTO> findAll() {
        return animalDAO.findAll();
    }

    public AnimalDTO findByCode(String code) {
        return animalDAO.findByCode(code);
    }


}

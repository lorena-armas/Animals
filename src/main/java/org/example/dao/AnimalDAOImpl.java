package org.example.dao;

import org.example.commons.CsvReader;
import org.example.dto.AnimalDTO;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAOImpl implements AnimalDAO {

    private final String FILE = "/animals/animals.csv";
    private static final char SEPARATOR =',';


    @Override
    public List<AnimalDTO> findAll() {
        List<AnimalDTO> animalList = new ArrayList<>();
        try{
            CsvReader.getRecords(FILE, SEPARATOR)
                    .forEach(csvRecord -> {

                        AnimalDTO animal = AnimalDTO.builder()
                                .name(csvRecord.get("NAME"))
                                .type(csvRecord.get("TYPE"))
                                .code(csvRecord.get("CODE"))
                                .build();

                        animalList.add(animal);
            });
        } catch (Exception exception) {
            throw new IllegalArgumentException("Error reading CSV", exception);
        }
        return animalList;
    }

    @Override
    public AnimalDTO findByCode(String code) {
        List<AnimalDTO> allAnimal = this.findAll();
        for (AnimalDTO animal: allAnimal) {
            if (animal.getCode().equals(code)) {
                return animal;
            }
        }
        throw new IllegalArgumentException("No such animal");
    }
}

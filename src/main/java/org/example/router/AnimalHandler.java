package org.example.router;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.AnimalDTO;
import org.example.service.AnimalService;
import org.example.service.AnimalServiceImpl;
import java.io.PrintWriter;
import java.util.List;

public class AnimalHandler {

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final AnimalService animalService;

    public AnimalHandler() {
        animalService = new AnimalServiceImpl();
    }

    public void findAll(PrintWriter output) throws JsonProcessingException {
        List<AnimalDTO> animalList = animalService.findAll();
        String animalListJson = objectMapper.writeValueAsString(animalList);

        output.println(animalListJson);
    }

    public void findByCode(String animalCode, PrintWriter output) throws JsonProcessingException {
        AnimalDTO animalList = animalService.findByCode(animalCode);
        String animalJson = objectMapper.writeValueAsString(animalList);

        output.println(animalJson);
    }
}

package com.dmuench.healthtrackerbackend;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ExerciseController {

    @Autowired
    private ExerciseRepository exerciseRepo;

    @PostMapping(value = "/exercises")
    public void createNewExercise(
            @RequestParam String title,
            @RequestParam String quantity,
            @RequestParam String description) {

        Exercise newExercise = new Exercise(title, quantity, description, new Date().toString());
        exerciseRepo.save(newExercise);
    }

    @GetMapping(value = "/exercises")
    public String getExercises() {
        Gson gson = new Gson();
        String exerciseJson = gson.toJson(exerciseRepo.findAll());
        return exerciseJson;
    }
}

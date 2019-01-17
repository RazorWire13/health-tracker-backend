package com.dmuench.healthtrackerbackend;

import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}

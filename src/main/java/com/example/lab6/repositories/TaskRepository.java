package com.example.lab6.repositories;

import com.example.lab6.models.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {

    @Override
    void deleteById(Long aLong);

    Optional<Task> findByIsDone(Boolean isDone);

    Optional<Task> findByCostLessThan(Double cost);

    Optional<Task> findByCostBetween(Double cost, Double cost2);

}


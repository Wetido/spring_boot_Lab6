package com.example.lab6.repositories;

import com.example.lab6.models.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("tasks")
public interface TaskRepository extends CrudRepository<Task, Long> {

    @Override
    void deleteById(Long aLong);

    Optional<Task> findByIsDone(Boolean isDone);

    Optional<Task> findByCostLessThan(Double cost);

    List<Task> findAllByCostBetween(Double cost, Double cost2);

}


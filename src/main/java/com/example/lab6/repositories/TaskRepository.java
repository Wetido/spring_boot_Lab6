package com.example.lab6.repositories;

import com.example.lab6.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> { }


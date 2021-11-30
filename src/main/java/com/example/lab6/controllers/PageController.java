package com.example.lab6.controllers;


import com.example.lab6.models.Task;
import com.example.lab6.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class PageController {

    @Autowired
    public TaskRepository taskRepository;

    @RequestMapping("/")
    @ResponseBody
    public String mainPage() {
        return "Hello Spring Boot from mainPage() method!";
    }


    @RequestMapping("/hello")
    @ResponseBody
    public String pageTwo() {
        return "Hello Spring Boot from pageTwo() method!";
    }


    @RequestMapping("/taskList")
    @ResponseBody
    public String taskList() {
        StringBuilder response = new StringBuilder();

        for (Task task : taskRepository.findAll()) {
            response.append(task).append("<br>");
        }

        return response.toString();
    }

    @RequestMapping("/generateTasks")
    @ResponseBody
    public void generateTasks() {
        Task task;
        double cost = 1000;
        boolean isDone = false;
        for (int i = 1; i <= 10; i++) {
            task = new Task();
            task.setName("zadanie " + i);
            task.setDescription("Opis czynnosci do wykonania w zadaniu numer " + i);
            task.setCost(cost);
            task.setDone(isDone);

            isDone = !isDone;
            cost += 200.50;

            taskRepository.save(task);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable long id) {
        taskRepository.deleteById(id);
    }

    @RequestMapping(value="/cost/{min}/{max}", method = RequestMethod.GET)
    @ResponseBody
    public String findByCostBetween(@PathVariable double min, @PathVariable double max){

        System.out.println(Double.toString(min) + ", " + Double.toString(max));
        StringBuilder response = new StringBuilder();

        List<Task> tasks = taskRepository.findAllByCostBetween(min, max);

        for (Task task :tasks) {
            System.out.println(task.getCost());
            response.append(task).append("<br>");
        }

//        tasks.stream(e -> { response.append(e).append("<br>"); });
        System.out.println(response.toString());

        return response.toString();
    }
}

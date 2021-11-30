package com.example.lab6.controllers;


import com.example.lab6.models.Task;
import com.example.lab6.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        Task zadanie = new Task();
        //korzystając z obiektu repozytorium zapisujemy zadanie do bd
        taskRepository.save(zadanie);
        //korzystając z obiektu repozytorium pobieramy wszystkie zadania z bd

        for(Task task: taskRepository.findAll()) {
            response.append(task).append("<br>");
        }

        return response.toString();
    }

}

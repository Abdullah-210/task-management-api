package com.abdullah.taskmanager.controller;

import com.abdullah.taskmanager.model.Task;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.abdullah.taskmanager.repository.TaskRepository;
import java.util.List;

@RestController
public class HelloController {

    private final TaskRepository taskRepository;

    public HelloController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String hello() {
        return "API Working";
    }

    @PostMapping("/tasks")
    public String createTask(@RequestBody Task task) {
        taskRepository.save(task);
        return "Task created: " + task.getTitle();
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
}
package com.abdullah.taskmanager.controller;

import com.abdullah.taskmanager.model.Task;
import com.abdullah.taskmanager.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String hello() {
        return "API Working";
    }

    @PostMapping("/tasks")
    public String createTask(@Valid @RequestBody Task task,
                             HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        return taskService.createTask(task, username);
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        return taskService.getTasks(username);
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id,
                            HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        return taskService.getTaskById(id, username);
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id,
                             HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        return taskService.deleteTask(id, username);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id,
                           @Valid @RequestBody Task updatedTask,
                           HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        return taskService.updateTask(id, updatedTask, username);
    }
}
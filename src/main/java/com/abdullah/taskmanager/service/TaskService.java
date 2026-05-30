package com.abdullah.taskmanager.service;

import com.abdullah.taskmanager.model.Task;
import com.abdullah.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public String createTask(Task task) {
        taskRepository.save(task);
        return "Task created: " + task.getTitle();
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public String deleteTask(Long id) {
        taskRepository.deleteById(id);
        return "Task deleted with id: " + id;
    }

    public Task updateTask(Long id, Task updatedTask) {

        Task task = taskRepository.findById(id).orElse(null);

        if (task == null) {
            return null;
        }

        task.setTitle(updatedTask.getTitle());

        return taskRepository.save(task);
    }
}
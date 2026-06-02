package com.abdullah.taskmanager.service;

import com.abdullah.taskmanager.model.Task;
import com.abdullah.taskmanager.repository.TaskRepository;
import com.abdullah.taskmanager.user.User;
import com.abdullah.taskmanager.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public String createTask(Task task, String username) {
        User user = userRepository.findByUsername(username).orElse(null);

        if (user == null) {
            return "User not found";
        }

        task.setUser(user);
        taskRepository.save(task);

        return "Task created: " + task.getTitle();
    }

    public List<Task> getTasks(String username) {
        return taskRepository.findByUserUsername(username);
    }

    public Task getTaskById(Long id, String username) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task == null) {
            return null;
        }

        if (task.getUser() == null || !task.getUser().getUsername().equals(username)) {
            return null;
        }

        return task;
    }

    public String deleteTask(Long id, String username) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task == null) {
            return "Task not found";
        }

        if (task.getUser() == null || !task.getUser().getUsername().equals(username)) {
            return "You are not allowed to delete this task";
        }

        taskRepository.delete(task);
        return "Task deleted with id: " + id;
    }

    public Task updateTask(Long id, Task updatedTask, String username) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task == null) {
            return null;
        }

        if (task.getUser() == null || !task.getUser().getUsername().equals(username)) {
            return null;
        }

        task.setTitle(updatedTask.getTitle());

        return taskRepository.save(task);
    }
}
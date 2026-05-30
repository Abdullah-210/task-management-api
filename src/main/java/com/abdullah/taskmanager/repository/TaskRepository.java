package com.abdullah.taskmanager.repository;

import com.abdullah.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUserUsername(String username);
}
package org.uce.spaguettimonolitic.service;

import org.uce.spaguettimonolitic.model.Task;
import org.uce.spaguettimonolitic.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(String title) {
        if (title == null) {
            throw new RuntimeException("Title required");
        }

        Task task = new Task(System.currentTimeMillis(), title, "Pending");
        repository.save(task);

        return task;
    }

    public List<Task> getAll() {
        return repository.findAll();
    }

    public Task update(Long id, String title, String status) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        if (title != null) {
            task.setTitle(title);
        }

        if (status != null) {
            task.setStatus(status);
        }

        return task;
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
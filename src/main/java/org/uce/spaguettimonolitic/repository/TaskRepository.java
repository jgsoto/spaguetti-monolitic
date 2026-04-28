package org.uce.spaguettimonolitic.repository;

import org.uce.spaguettimonolitic.model.Task;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();

    public List<Task> findAll() {
        return tasks;
    }

    public Optional<Task> findById(Long id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public void save(Task task) {
        tasks.add(task);
    }

    public void delete(Long id) {
        tasks.removeIf(t -> t.getId().equals(id));
    }
}